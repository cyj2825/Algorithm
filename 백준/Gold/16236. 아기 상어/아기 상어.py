# 다시 풀어보기
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
# 상하좌우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
count = 0
answer = 0
# 상어의 위치 초기화 및 상어의 초기 사이즈 2
x, y, size = 0, 0, 2
# 상어의 위치 받기
for i in range(n):
    for j in range(n):
        if data[i][j] == 9:
            x, y = i, j

# 먹을 수 있는 물고기가 1마리라면 그 물고기를 먹으러 간다
# 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고리를 먹으러 간다
def BFS(x, y, size):
    # 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때 지나야 하는 칸의 개수의 최솟값
    distance = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    t = []
    # q가 빌 때까지 반복
    while q:
        cur_x, cur_y = q.popleft()
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if data[nx][ny] <= size:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[cur_x][cur_y] + 1
                    if data[nx][ny] < size and data[nx][ny] != 0:
                        t.append((nx, ny, distance[nx][ny]))
    # 거리가 가까운 물고기가 많다면 가장 위에 있는 물고기, 가장 왼쪽에 있는 물고기 순으로 먹는다
    return sorted(t, key = lambda x: (-x[2], -x[0], -x[1]))

while 1:
    babyshark = BFS(x, y, size)
    # 더 이상 먹을 수 있는 물고기가 공간에 없다면 엄마 상어에게 도움을 요청
    if len(babyshark) == 0:
        break

    nx, ny, dist = babyshark.pop()
    # 움직이는 칸수가 걸리는 시간에 해당
    answer += dist
    # 아기 상어가 존재한 위치와 이동한 위치 모두 0으로 변경
    data[x][y], data[nx][ny] = 0, 0
    # 아기 상어 위치를 먹은 물고기 위치로 옮겨주기
    x, y = nx, ny
    count += 1
    if count == size:
        size += 1
        count = 0

print(answer)