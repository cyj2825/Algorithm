# 다시보기
# 백준 14888번 연산 끼워넣기
# 백트래킹이란? 해를 찾는 도중 해가 아니어서 막히면 되돌아가서 다시 해를 찾는 기법
import sys
# 재귀함수 사용할 때 밑의 코드 추가
sys.setrecursionlimit(10**8)
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))
op = list(map(int, input().split()))    # 연산 리스트 +, -, *, / 순으로
# 최대값, 최소값 초기화
maxNum = -1e9
minNum = 1e9

def DFS(i, total, plus, minus, multiply, divide):
    global maxNum, minNum
    # 모든 연산자 끼워넣기를 완료하였으면 total값과 maxNum, minNum 값을 각각 비교하여 maxNum과 minNum 값을 갱신
    if i == n:
        maxNum = max(total, maxNum)
        minNum = min(total, minNum)
        return
    # 백트래킹이 원활히 진행되려면 if elif elif.. 이런식으로 코드를 구현할 것이 아니라 if if if 이렇게 구현해야 할듯!
    # op[0]값에 해당하는 + 연산자 개수가 0이 아니라면
    if plus:
        DFS(i+1, total + data[i], plus-1, minus, multiply, divide)
    # op[1]값에 해당하는 - 연산자 개수가 0이 아니라면
    if minus:
        DFS(i + 1, total - data[i], plus, minus - 1, multiply, divide)
    # op[2]값에 해당하는 * 연산자 개수가 0이 아니라면
    if multiply:
        DFS(i + 1, total * data[i], plus, minus, multiply - 1, divide)
    # op[3]값에 해당하는 / 연산자 개수가 0이 아니라면
    # 나눗셈의 경우는 몫만 취함, 음수를 양수로 나눌 때는 음수를 양수로 바꾸고 결과값을 음수로 바꾸면 된다고 했지만 이를 int(total/data[i])로 쓸 수 있음
    if divide:
        DFS(i + 1, int(total / data[i]), plus, minus, multiply, divide - 1)

# index 값을 0이 아닌 1부터 시작하는 이유는 첫번째값은 연산자 끼워넣기에 해당하는 값이 아님
DFS(1, data[0], op[0], op[1], op[2], op[3])
print(maxNum)
print(minNum)