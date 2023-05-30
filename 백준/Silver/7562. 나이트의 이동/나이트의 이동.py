from collections import deque
import sys
input = sys.stdin.readline
# 나이트가 한 번에 이동할 수 있는 좌표
dx = [1, 1, -1, -1, 2, 2, -2, -2]
dy = [2, -2, 2, -2, 1, -1, 1, -1]

def BFS(sx, sy, ex, ey):
    q = deque()
    q.append((sx, sy))
    visit[sx][sy] = 1
    
    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        if x == ex and y == ey:
            print(visit[ex][ey] - 1)
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visit[nx][ny] == 0:
                # 나이트가 현재 위치에서 이동하려고 하는 위치까지 가기 위한 최소 이동 수를 구하기 위함
                visit[nx][ny] = visit[x][y] + 1
                q.append((nx, ny))

T = int(input())
for i in range(T):
    n = int(input())
    # 나이트가 현재 있는 칸
    sx, sy = map(int, input().split())
    # 나이트가 이동하려고 하는 칸
    ex, ey = map(int, input().split())
    # 방문 여부 판단 리스트 + 움직여야 하는 칸 수 세기
    visit = [[0] * n for _ in range(n)]
    BFS(sx, sy, ex, ey)