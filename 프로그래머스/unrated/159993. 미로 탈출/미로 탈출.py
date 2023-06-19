from collections import deque

def BFS(s, e, maps):
	# 상하좌우 이동
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    n = len(maps)       # 세로
    m = len(maps[0])    # 가로
    visited = [[False] * m for _ in range(n)]
    q = deque()
    find = False
    
    # 초깃값 설정
    for i in range(n):
        for j in range(m):
        	# 출발하고자 하는 지점이라면 시작점의 좌표를 기록함
            if maps[i][j] == s:
                # x, y, 걸리는 최소 시간을 q에 넣기
                q.append((i, j, 0))
                visited[i][j] = True
                find = True; break
        if find: break
                
    # q가 빌 때까지 반복
    while q:
        y, x, count = q.popleft()
        
        if maps[y][x] == e:
            return count
        
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            # maps 범위내에서 벽이 아니라면 지나갈 수 있음
            if 0<= ny <n and 0<= nx <m and maps[ny][nx] !='X' and not visited[ny][nx]:
                q.append((ny, nx, count+1))
                visited[ny][nx] = True
    # 탈출할 수 없을 시에 -1 값 return
    return -1
        
def solution(maps):
    # 출발점에서 레버에 갔다가 레버에서 출구로 가는 경우가 모두 가능해야 함
    toL = BFS('S', 'L', maps)
    toE = BFS('L', 'E', maps)
    
    # 둘다 -1 이 아니라면 탈출할 수 있음
    if toL != -1 and toE != -1:
        return toL + toE
        
   	# 둘중 하나라도 -1 이면 탈출할 수 없음
    return -1