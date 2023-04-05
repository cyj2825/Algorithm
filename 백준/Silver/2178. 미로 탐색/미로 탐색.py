# 다시보기
from collections import deque
n, m = map(int, input().split())
# nxm의 크기 배열 값 넣기
A = [list(map(int, input())) for _ in range(n)]

def BFS(x, y):
    # 이동할 상, 하, 좌, 우 방향 정의
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    myQueue = deque()
    myQueue.append((x,y))
    
    while myQueue:
        x, y = myQueue.popleft()
        # 현재 위치에서 4가지 방향 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # nxm 배열을 벗어나면 안되므로 해당 조건 추가
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            # 0은 벽이므로 지나갈 수 없으므로 해당 조건 추가
            if A[nx][ny] == 0:
                continue
            if A[nx][ny] == 1:
                A[nx][ny] = A[x][y] + 1
                myQueue.append((nx,ny))
    # 마지막 값에서 지나야 하는 최소값 받기
    return A[n-1][m-1]
print(BFS(0,0))