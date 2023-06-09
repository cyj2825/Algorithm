from collections import deque
import sys
import copy
input = sys.stdin.readline
# 지도의 세로 크기 N, 가로 크기 M
n, m = map(int, input().split())
data = [list(map(int, input().split())) for _ in range(n)]
# 상하좌우로 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 0
# 값이 2인 바이러스는 상하좌우의 인접합 빈칸 0으로만 이동이 가능하기 때문에 먼저 2인 값들을 모두 큐에 넣어준 후에
# BFS를 통해 큐에서 하나씩 꺼내 확장시키는 방식으로 진행 -> 2인 칸에서 시작하여 주변의 0인 칸들을 2로 만드는 방식
# 이때 어디에 벽을 세워야 최댓값이 나올지는 알 수 없기 때문에 벽을 세울 수 있는 모든 경우의 수에 대해 수행해야 함
# 따라서 (1,1)칸부터 (n,m)칸까지 중 빈칸을 순서대로 하나씩 3개 선택하여 벽을 세우고 BFS를 수행한 후 벽을 지우고
# 그 다음칸에 대해 다시 벽을 세우고 BFS를 수행하고 벽을 지우는 방식을 반복해야 함
# 즉 백트래킹 방식을 이용해 3개의 벽을 모든 칸에 세워본다

def BFS():
    q = deque()
    # 깊은 복사하여 tmp_data 생성
    tmp_data = copy.deepcopy(data)
    for i in range(n):
        for j in range(m):
            if tmp_data[i][j] == 2:
                q.append((i, j))

    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and tmp_data[nx][ny] == 0:
                tmp_data[nx][ny] = 2
                q.append((nx, ny))
    global answer
    count = 0
    for i in range(n):
        # 3개의 벽을 세우고 안전영역의 크기(0의 개수) 구하기
        count += tmp_data[i].count(0)

    answer = max(answer, count)

# 3개의 벽 세우기 위한 함수
def makeWall(wall):
    if wall == 3:
        BFS()
        return

    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                data[i][j] = 1
                makeWall(wall + 1)
                data[i][j] = 0

makeWall(0)
print(answer)