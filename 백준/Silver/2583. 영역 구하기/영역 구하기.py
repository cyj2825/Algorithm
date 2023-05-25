# BFS 문제
from collections import deque
import sys
input = sys.stdin.readline
# 행, 열, 사각형의 개수
m, n, k = map(int, input().split())
# 모눈종이
graph = [[0] * n for _ in range(m)]
# 상, 하, 좌, 우로 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# 분리되어 나누어지는 영역의 수
count = 0
# 각 영역의 넓이 리스트
answer = []

# 모눈종이에 사각형이 존재하는 자리의 값을 1로 변경
for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    # 이때 x와 y의 행,열 상태를 헷갈리지 말자!
    # 해당 문제의 경우 y값이 행, x값이 열
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = 1

def BFS(a, b):
    q = deque()
    q.append((a, b))
    # 한 번 방문하면 0값을 1로 바꾸어 다시는 방문하지 않도록 함
    graph[a][b] = 1
    sol = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < m and 0 <= ny < n and graph[nx][ny] == 0:
                graph[nx][ny] = 1
                q.append((nx, ny))
                sol += 1

    return sol

for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            answer.append(BFS(i, j))
            count += 1

# 오름차순으로 정렬하여 출력
answer.sort()
print(count)
print(*answer)