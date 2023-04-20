# 다시보기
# 좌표 개념으로 생각하여 아래, 오른쪽, 위, 왼쪽을 순서대로 탐색 => 조건에 맞지 않으면 오른쪽으로 넘어가고 또 조건에 맞지 않으면 위쪽으로 넘어가고..
import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
# 좌표값 채우기
data = [[0] * n for _ in range(n)]

# 아래, 오른, 위, 왼 순서로 이동
# 달팽이 좌표값이 채워지는 규칙 : 특정값이 조건에 맞으면 아래, 조건에 맞지 않으면 오른쪽으로, 그 조건도 맞지 않으면 위쪽으로...
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
# (0, 0)에 넣을 값, 즉 n**2값(n**2부터 1까지 좌표를 채워가는 것이므로)
num = n ** 2
i = 0
x, y = 0, 0

while True:
    data[x][y] = num
    # 아래, 오른, 위, 왼 순서로 이동하기 위해
    nx = x + dx[i]
    ny = y + dy[i]

    # nx, ny값이 0~n-1 값 사이를 벗어나거나 0이 아닌(이미 값이 들어가있는) 상태일 때는 아래, 오른, 위, 왼 순서 변경
    if nx < 0 or ny < 0 or nx >= n or ny >= n or data[nx][ny] != 0:
        i += 1
        if i == 4:
            i = 0
        continue    # 밑에 코드들 수행하지 않고 while문 맨 앞으로 돌아감

    x, y = nx, ny
    # n**2부터 1까지 채우기 위해 값을 1씩 줄여가며 while문 반복
    num -= 1
    if num == 1:
        break
data[x][y] = 1

for i in range(n):
    for j in range(n):
        # data 리스트를 돌면서 좌표값을 출력할 때 m 값을 갖고 있는 index값도 저장
        if data[i][j] == m :
            a, b = i+1, j+1
    # data리스트 x값 한 줄씩 출력
    print(*data[i])
print(a, b)