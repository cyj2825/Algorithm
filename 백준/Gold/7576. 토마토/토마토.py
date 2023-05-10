from collections import deque
import sys
input = sys.stdin.readline
# 가로 길이 : m, 세로 길이 : n
m, n = map(int, input().split())
# 이차원 리스트로 토마토 상태 넣기
data = [list(map(int, input().split())) for _ in range(n)]
# 좌표를 넣을 것이기에 []로 넣는다
q = deque([])
# 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 0

# 이렇게 했을 때의 장점은 data의 값 중 1을 발견했을 때마다 BFS 함수를 호출하는 for문을 또 실행하지 않아도 됨
for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            q.append([i, j])

# 해당 BFS 함수는 이미 이중 for문을 통해 1값을 갖는 x, y 좌표 값은 다 append 했으므로 안에서 그 작업을 해주지 않아도 됨
# 이렇게 할 수 있는 이유는 BFS의 다른 문제 유형에 해당하는 묶음 개수 찾기 문제가 아니라 최소 일수를 찾는 문제이기 때문
def BFS():
    # q가 빌 때까지 반복
    while q:
        # 앞서 이중 for문을 통해 1값을 갖는 x, y 좌표 값은 다 append 했으니까 그걸 꺼내서 익지 않은 토마토를 익히면 됨
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # nx와 ny가 좌표 안에 들어있어야 하고 해당 좌표의 data값이 0이어야 함(토마토가 안 익은 상태)
            if 0 <= nx < n and 0 <= ny < m and data[nx][ny] == 0:
                # 최소 일수를 구해야 하기 때문에 visited를 따로 만들지 않고 data으로 일수값을 갱신 -> 여기서 나온 최댓값이 정답
                data[nx][ny] = data[x][y] + 1
                q.append([nx, ny])

BFS()
for i in data:
    for j in i:
        # BFS함수로 다 돌았는데 아직도 익지 않은 토마토가 있다면 모두 익힐 수 없는 것이므로 -1 출력
        if j == 0:
            print(-1)
            exit(0)
    # 모두 익혔다면 answer 값을 최댓값으로 갱신
    answer = max(answer, max(i))

# 맨 처음 시작값이 0이 아니라 1이므로 -1 해줘야 함
print(answer - 1)