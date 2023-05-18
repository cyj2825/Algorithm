from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
data = [list(input()) for _ in range(n)]
visited1 = [[False] * n for _ in range(n)]
visited2 = [[False] * n for _ in range(n)]
color = ''
# 상, 하, 좌, 우 이동
dx= [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
count1, count2 = 0, 0

# 적록색약이 아닌 사람이 봤을 때의 구역의 수 구하는 함수
def BFS_normal(a, b):
    q = deque()
    q.append((a, b))
    visited1[a][b] = True
    while q:
        x, y = q.popleft()
        color = data[x][y]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited1[nx][ny] and data[nx][ny] == color:
                visited1[nx][ny] = True
                q.append((nx, ny))

# 적록색약인 사람이 봤을 때의 구역의 수 구하는 함수
def BFS_not(a, b):
    q = deque()
    q.append((a, b))
    visited2[a][b] = True
    while q:
        x, y = q.popleft()
        color = data[x][y]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited2[nx][ny]:
                if data[nx][ny] == 'B' and color == 'B':
                    visited2[nx][ny] = True
                    q.append((nx, ny))
                elif (data[nx][ny] == 'R' or data[nx][ny] == 'G') and (color == 'R' or color == 'G'):
                    visited2[nx][ny] = True
                    q.append((nx, ny))

for i in range(n):
    for j in range(n):
        if not visited1[i][j]:
            count1 += 1
            BFS_normal(i, j)
        if not visited2[i][j]:
            count2 += 1
            BFS_not(i, j)

print(count1, count2)