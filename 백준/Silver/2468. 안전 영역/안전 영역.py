# 다시보기
# 너비 우선 탐색(BFS) 사용
import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
data = []      # 높이 정보 리스트
maxNum = 0     # 배열값 중 가장 큰 값
result = 0

# 높이 정보 받아와 넣고 그 배열값 중 가장 큰 값을 maxNum에 넣는다
for i in range(n):
    data.append(list(map(int, input().split())))
    for j in range(n):
        if maxNum < data[i][j]:
            maxNum = data[i][j]

# 이동할 상, 하, 좌, 우 방향 정의
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# BFS할 배열 인덱스값 a,b와 0~maxNum-1이 들어가는 value, 새로운 value값마다 바뀌는 visited
def BFS(a, b, value, visited):
    myQueue = deque()
    myQueue.append((a, b))
    visited[a][b] = 1    # 방문했음을 의미하는 1로 값 변경

    while myQueue:       # 큐가 빌 때까지 반복
        x, y = myQueue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 배열 크기를 벗어나지 않고
            if 0 <= nx < n and 0 <= ny < n:
                # 방문한 적이 없으며 value(비 높이)보다 크다면
                if visited[nx][ny] == 0 and data[nx][ny] > value:
                    visited[nx][ny] = 1
                    myQueue.append((nx, ny))

for h in range(maxNum):
    # 방문 여부 리스트 h 값이 바뀔 때마다 초기화
    visited = [[0]*n for _ in range(n)]
    count = 0       # h 값이 바뀔 때마다 count 값 초기화

    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and data[i][j] > h:
                BFS(i, j, h, visited)
                count += 1
    if result < count:
        result = count

print(result)