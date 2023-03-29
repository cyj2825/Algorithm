# 다시보기
n = int(input())
A = list(map(int, input().split()))
answer = [0] * n    # 오큰수 저장하는 정답 리스트
myStack = []

for i in range(n):
    # myStack이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
    while myStack and A[myStack[-1]] < A[i]:
        answer[myStack.pop()] = A[i]    # 정답 리스트에 오큰수를 현재 수열로 저장하기
    myStack.append(i)
    
# 앞의 반복문이 종료되었지만 myStack이 비어있지 않으면 빌 때까지 해당 while문 실행
while myStack:
    answer[myStack.pop()] = -1

for i in answer:
    print(i)