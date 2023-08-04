from collections import deque
import sys
input = sys.stdin.readline
# n : 통로의 세로 길이, m : 통로의 가로 길이, k : 음식물 쓰레기의 개수
n, m, k = map(int, input().split())
data = [[0] * m for _ in range(n)]
# 상, 하, 좌, 우로만 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
maxVal = 0
visited = [[False] * m for _ in range(n)]

for _ in range(k):
    x, y = map(int, input().split())
    data[x-1][y-1] = 1

def BFS(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = True
    # q가 빌 때까지 반복
    count = 1
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and data[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    return count

for i in range(n):
    for j in range(m):
        if data[i][j] == 1 and not visited[i][j]:
            a = BFS(i, j)
            maxVal = max(a, maxVal)
print(maxVal)