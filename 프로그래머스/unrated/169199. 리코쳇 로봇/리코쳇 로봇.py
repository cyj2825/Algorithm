from collections import deque

def solution(board):
    answer = 0
    r = len(board)
    c = len(board[0])
    # 로봇의 처음 위치인 R의 x, y 값 초기화
    rx, ry = 0, 0
    # 로봇의 처음 위치인 R의 x, y 값 받아오기
    for i in range(r):
        for j in range(c):
            if board[i][j] == 'R':
                rx, ry = i, j
                
    # 상하좌우로 이동
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[0] * c for _ in range(r)]
    
    
    def BFS():
        q = deque()
        q.append((rx,ry))
        visited[rx][ry] = 1
        
        # q가 빌 때까지 반복
        while q:
            x, y = q.popleft()
            # 목표지점인 G에 도착하면 visited값 return
            if board[x][y] == 'G':
                return visited[x][y]
            # 상하좌우
            for i in range(4):
                nx, ny = x, y
                # 사방으로 이동할 때 바로 다음 칸으로 이동하는 것이 아닌 벽이나 장애물에 부딪힐 때까지 이동
                while True:
                    nx, ny = nx + dx[i], ny + dy[i]
                    # 장애물에 부딪힐 경우
                    if 0 <= nx < r and 0 <= ny < c and board[nx][ny] == 'D':
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                    # 범위에 벗어날 경우
                    if nx < 0 or nx >= r or ny < 0 or ny >= c:
                        nx -= dx[i]
                        ny -= dy[i]
                        break
                if not visited[nx][ny]:
                    # 이동횟수 측정하기 위한 식
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))
        return -1
    answer = BFS()
    if answer > 0:
        # 첫 칸을 제외하기 위해 -1
        answer -= 1
    return answer