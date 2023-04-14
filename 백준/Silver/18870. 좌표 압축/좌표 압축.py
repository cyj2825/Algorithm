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
    print(answer[i][2], end =' ')