# BFS 문제
from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
# 빙산 상태값 받기
data = [list(map(int, input().split())) for _ in range(n)]
# 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0
# 빙산 있는 위치만 탐색하기 위해 ice에 빙산 위치를 저장
ice = []
for i in range(n):
    for j in range(m):
        if data[i][j]:
            ice.append((i, j))

def BFS(a, b):
    q = deque()
    q.append((a, b))
    visited[a][b] = 1
    # 빙산 하나 탐색하고 바로 녹여 0이 되었을 경우 다음 빙산이 해당 빙산을 바다로 인식해버려 카운트할 수 있으므로
    # 연결된 빙산을 모두 탐색한 후 빙산을 녹여야 함!
    seaList = []

    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        sea = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                # data 값이 0일 경우 바다이므로 +1
                if not data[nx][ny]:
                    sea += 1
                # 만약 data 값이 0이 아니고 이전에 방문한 적이 없다면 해당 위치도 상하좌우 바다 위치 파악 탐색 진행
                elif data[nx][ny] and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = 1

        # 주변에 바다가 존재할 경우 seaList에 위치값 x, y와 바다 수 저장
        if sea > 0:
            seaList.append((x, y, sea))
    # 연결된 모든 빙산의 탐색이 끝났을 경우 저장해 둔 바다 수를 data값에서 빼기
    # 무조건 0 값이상이어야 하므로 max 사용
    for x, y, sea in seaList:
        data[x][y] = max(0, data[x][y] - sea)
    # group으로 빙산 수를 세야 하므로 return 1
    return 1


# 현재 바다가 아닌 빙산인 값들 BFS 실행
while ice:
    visited = [[False] * m for _ in range(n)]
    # 탐색이 끝나고 바다가 된 빙산이 있는지 체크하고 ice에서 제거하기 위한 위치 저장 리스트
    delList = []
    group = 0
    for i, j in ice:
        if data[i][j] and not visited[i][j]:
            group += BFS(i, j)
        # 탐색이 끝나면 바다가 된 빙산 체크
        # 만약 바로 제거하면 for문이 정상동작하지 않으므로 for문이 끝나고 제거하기 위해 위치 저장
        if data[i][j] == 0:
            delList.append((i, j))
    # 빙산 그룹이 2개 이상이면 년 출력
    if group > 1:
        print(year)
        break
    # 다 녹은 빙산은 탐색할 필요가 없으므로 ice에서 제거
    ice = sorted(list(set(ice) - set(delList)))
    year += 1
# 빙산이 다 녹을 때까지 분리되지 않으면 0 출력
if group < 2:
    print(0)