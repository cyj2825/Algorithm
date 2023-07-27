from collections import deque
import sys
input = sys.stdin.readline

# 세로 크기 n, 가로 크기 m
n, m = map(int, input().split())
# 상, 하, 좌, 우로 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
# 도화지 값 받기
data = [list(map(int, input().split())) for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]
# count 값을 저장할 리스트
countList = []
answer = 0

# 너비 우선 탐색
def BFS(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = True
    count = 1

    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 1은 색칠이 된 부분을 의미
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and data[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny))
                data[nx][ny] = 0
                count += 1
    return count

for i in range(n):
    for j in range(m):
        if data[i][j] == 1 and not visited[i][j]:
            countList.append(BFS(i, j))
            answer += 1
if len(countList) > 0:
    countList.sort()
    print(answer)
    print(countList[-1])
else:
    print(0)
    print(0)