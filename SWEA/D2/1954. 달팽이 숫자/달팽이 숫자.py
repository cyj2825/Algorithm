T = int(input())
# 달팽이 방향 우 -> 하 -> 좌 -> 상
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

for test_case in range(1, T + 1):
    n = int(input())
    data = [[0] * n for _ in range(n)]
    # 초기 위치
    r, c = 0, 0
    # 0 : 우, 1 : 하, 2 : 좌, 3 : 상
    dir = 0
    for i in range(1, n**2+1):
        data[r][c] = i
        r += dx[dir]
        c += dy[dir]
        
        # 범위를 벗어나거나 이미 data 값이 0에서 다른 것을 변경되었을 경우 원위치 시키고 방향 변경
        if r < 0 or r >= n or c < 0 or c >= n or data[r][c] != 0:
            r -= dx[dir]
            c -= dy[dir]
            # 방향 변경(우하좌상)
            dir = (dir + 1) % 4
            r += dx[dir]
            c += dy[dir]
    print(f'#{test_case}')
    for i in data:
        print(*i)