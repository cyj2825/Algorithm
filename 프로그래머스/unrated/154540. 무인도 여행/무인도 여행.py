from collections import deque
# 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def BFS(maps, i, j, n, m, visited):
    q = deque()
    q.append([i, j])
    visited[i][j] = True
    data = 0
    while q:
        x, y = q.popleft()
        # 각 섬마다 지낼 수 있는 일수를 구하기 위해
        data += int(maps[x][y])
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and maps[nx][ny] != 'X':
                q.append([nx, ny])
                visited[nx][ny] = True
    return data

def solution(maps):
    answer = []
    n, m = len(maps), len(maps[0])
    visited = [[False] * m for _ in range(n)]
    
    # 전체 maps를 돌면서 'X'가 아니면서 방문하지 않은 값을 찾아 BFS 함수 실행
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visited[i][j]:
                answer.append(BFS(maps, i, j, n, m, visited))
    return sorted(answer) if answer else [-1]