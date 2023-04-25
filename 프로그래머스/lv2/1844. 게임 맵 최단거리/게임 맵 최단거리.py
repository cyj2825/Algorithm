from collections import deque
def solution(maps):
    answer = 0
    
    # 캐릭터를 상, 하, 좌, 우 방향으로 이동
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    def BFS(a, b):
        q = deque()
        q.append((a,b))
        # q가 빌 때까지 반복
        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                # 처음 지나가는 길이라면 거리 계산하고 다시 상하좌우 확인
                if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]) and maps[nx][ny] == 1:
                    # maps[nx][ny] 값은 maps[x][y]에 1 더한 값이고 그것을 대입하여 업데이트
                    # 최단 거리를 구하기 위해서는 해당 if문이 실행될 때마다 count값을 1씩 더해주는 방법이 아닌 maps를 업데이트하여 구해야 함!
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx, ny))
        # 상대 팀 진영 위치의 거리 값 반환
        return maps[len(maps)-1][len(maps[0])-1]
    answer = BFS(0,0)
    # 상대 팀 진영의 갈 수 없을 때는 해당 위치의 maps값이 변경되지 않았으므로 1이면 -1 값 리턴
    return -1 if answer == 1 else answer