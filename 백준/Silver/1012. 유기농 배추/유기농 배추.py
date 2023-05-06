# BFS 문제
from collections import deque
import sys
input = sys.stdin.readline
# 테스트 케이스의 개수 T
T = int(input())
# 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 너비우선탐색으로 구현 => 최소의 배추흰지렁이 수 구하기
def BFS(a, b, m, n, visited, data):
    q = deque()
    q.append((a, b))
    visited[a][b] = True

    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and data[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = True

# 테스트케이스마다 BFS 함수 실행
for i in range(T):
    m, n, k = map(int, input().split())
    # 방문한 곳인지 확인하기 위해
    visited = [[False for _ in range(m)] for _ in range(n)]
    data = [[0 for _ in range(m)] for _ in range(n)]
    count = 0
    # 배추가 심어져 있는 데이터 저장
    for j in range(k):
        a, b = map(int, input().split())
        data[b][a] = 1

    for l in range(n):
        for o in range(m):
            # data값이 1이고 아직 방문하지 않은 곳이 있을 경우 BFS 함수 실행
            if not visited[l][o] and data[l][o] == 1:
                BFS(l, o, m, n, visited, data)
                count += 1
    print(count)