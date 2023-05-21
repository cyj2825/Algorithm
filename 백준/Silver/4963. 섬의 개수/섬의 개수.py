from collections import deque
import sys
input = sys.stdin.readline
# 상, 하, 좌, 우, 상우, 상좌, 하우, 하좌 방향으로 이동
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, 1, -1, 1, -1]

def BFS(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = True
    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and data[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny))

while True:
    w, h = map(int, input().split())
    if w == 0 and h == 0:
        break
    else:
        data = [list(map(int, input().split())) for _ in range(h)]
        visited = [[False] * w for _ in range(h)]
        count = 0
        for i in range(h):
            for j in range(w):
                if data[i][j] == 1 and not visited[i][j]:
                    BFS(i, j)
                    count += 1
        print(count)