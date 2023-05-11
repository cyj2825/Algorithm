import sys
input = sys.stdin.readline
# 가로 길이 n, 세로 길이 m
n, m = map(int, input().split())
# 로봇 청소기의 위치 x, y와 바라보는 방향 pos
x, y, pos = map(int, input().split())
# 방문한 위치를 저장하기 위한 visited 리스트
visited = [[0] * m for _ in range(n)]
# 로봇 청소기 처음 위치 방문 처리
visited[x][y] = 1
# 각 장소의 상태값 받기
data = [list(map(int, input().split())) for _ in range(n)]
# 북, 동, 남, 서 방향으로 이동 => 반시계방향으로 90도 회전하기 때문
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
count = 1

while True:
    # 이동할 수 있는 방향이 존재하는지 확인
    state = 0
    # 0: 북, 1: 동, 2: 남, 3: 서
    for _ in range(4):
        # 0, 3, 2, 1 순서를 만들어주기 위함 => pos가 0일 경우 3이 나와 서쪽으로 이동
        nx = x + dx[(pos + 3) % 4]
        ny = y + dy[(pos + 3) % 4]
        pos = (pos + 3) % 4
        if 0 <= nx < n and 0 <= ny < m and data[nx][ny] == 0:
            if visited[nx][ny] == 0:
                visited[nx][ny] = 1
                count += 1
                state = 1         # 한 방향이라도 이동했으므로 이동할 수 있는 방향 존재하는 값 1로 변경
                x, y = nx, ny
                break

    # 네 방향 모두 청소할 수 없을 때
    if state == 0:
        # 바라보는 방향을 유지한 채로 한 칸 후진했을 때 벽일 경우는 더이상 이동할 수 없으므로 count값 출력 후 작동 종료
        if data[x - dx[pos]][y - dy[pos]] == 1:
            print(count)
            break
        # 바라보는 방향을 유지한 채로 한 칸 후진했을 때 벽이 아닐 경우
        else:
            x, y = x - dx[pos], y - dy[pos]