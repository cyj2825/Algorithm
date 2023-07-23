# 지나갈 수 있는 길 구하기
# 길이란 한 행 또는 한 열 전부를 나타내며, 한쪽 끝에서 다른쪽 끝까지 지나가는 것
# 크기 n과 경사로 길이 l 입력받기
n, l = map(int, input().split())
# nxn 지도 값 받기
graph = [list(map(int, input().split())) for _ in range(n)]
answer = 0

# 가로, 세로 줄을 받아 확인하는 함수
def check(line):
    for i in range(1, n):
        if abs(line[i] - line[i - 1]) > 1:
            return False
        if line[i] < line[i - 1]:
            for j in range(l):
                if i + j >= n or line[i] != line[i + j] or slope[i + j]:
                    return False
                if line[i] == line[i + j]:
                    slope[i + j] = True
        elif line[i] > line[i - 1]:
            for j in range(l):
                if i - j - 1 < 0 or line[i - 1] != line[i - j - 1] or slope[i - j - 1]:
                    return False
                if line[i - 1] == line[i - j - 1]:
                    slope[i - j - 1] = True
    return True

# 세로줄에서 지나갈 수 있는 길 개수 구하기
for i in range(n):
    slope = [False] * n
    if check([graph[i][j] for j in range(n)]):
        answer += 1
# 가로줄에서 지나갈 수 있는 길 개수 구하기
for j in range(n):
    slope = [False] * n
    if check([graph[i][j] for i in range(n)]):
        answer += 1

print(answer)