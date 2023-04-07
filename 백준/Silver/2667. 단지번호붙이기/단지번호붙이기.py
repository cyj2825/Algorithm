from collections import deque

def BFS(a, b):
    # 이동할 상, 하, 좌, 우 방향 정의
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    myQueue = deque()
    myQueue.append((a,b))
    # A의 탐색 시작점을 모르기 때문에 전체를 돌면서 1인 지점에서 탐색을 시작
    # 탐색 중 집이 존재하는 1인 부분은 0으로 바꿔 다시 방문하지 않도록 함
    A[a][b] = 0
    count = 1
    
    while myQueue:
        x, y = myQueue.popleft()
         # 현재 위치에서 4가지 방향 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # nxn 배열을 벗어나면 안되고 집이 존재하는 1의 값을 갖고 있어야 함
            if 0 <= nx < n and 0 <= ny < n and A[nx][ny] == 1:
                A[nx][ny] = 0
                myQueue.append((nx,ny))
                # 한 번의 BFS가 끝나게 되면 마을 하나가 탄생, count 값 1 증가
                count += 1
    return count

n = int(input())
A = [list(map(int, input())) for _ in range(n)]
data = []

for i in range(n):
    for j in range(n):
        if A[i][j] == 1:
            data.append(BFS(i,j))
data.sort()
print(len(data))
for i in range(len(data)):
    print(data[i])