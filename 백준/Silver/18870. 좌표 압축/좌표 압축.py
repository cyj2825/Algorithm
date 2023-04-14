# 다시보기
# dictionary 사용
import sys
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))
# data에서 중복값을 제외한 리스트를 오름차순으로 정렬
data2 = sorted(list(set(data)))

# {dic[요소] : 요소의 인덱스값}의 형태로 저장, 즉 dic[요소] 값을 갖는 모든 원소는 dic[요소]에 해당하는 인덱스값을 받음
dic = {data2[i] : i for i in range(len(data2))}

# data의 원소들을 모두 한 번씩 돌면서 그 값을 dic에 넣어 그 값에 맞는 인덱스를 받아와 출력
for i in data:
    print(dic[i], end = ' ')
    
    
'''
# 내가 작성한 코드! 시간이 5580ms가 나오므로 코드 개선 필요
import sys
input = sys.stdin.readline
n = int(input())
data = list(map(int, input().split()))
count = 0

answer = [[v, i] for i, v in enumerate(data)]
answer.sort()
for i in range(n):
    if i < n-1:
        if answer[i][0] == answer[i+1][0]:
            if len(answer[i]) == 3:
                answer[i+1].append(answer[i][2])
            elif len(answer[i]) < 3:
                answer[i].append(count)
                answer[i+1].append(count)
                count += 1
        else:
            if len(answer[i]) == 3:
                answer[i+1].append(count)
                count += 1
            elif len(answer[i]) < 3:
                answer[i].append(count)
                count += 1
    elif i == n-1:
        answer[i].append(count)

answer.sort(key=lambda x: x[1])
for i in range(n):
    print(answer[i][2], end =' ')'''