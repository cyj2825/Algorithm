import sys
input = sys.stdin.readline
n = int(input())
data = [[0]*n for _ in range(n)]
data[n//2][n//2] = 1
num = 2
x = n // 2
y = n // 2
# 좌표를 출력할 숫자 받아오기
q = int(input())
a = 0
b = 0
# 상, 하, 좌, 우로 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while x != 0 or y != 0:
    # 상, 하, 좌, 우로 값이 존재하는지 확인
    pos = [0, 0, 0, 0]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if i == 0 and data[nx][ny] != 0:
                pos[0] = 1
            elif i == 1 and data[nx][ny] != 0:
                pos[1] = 1
            elif i == 2 and data[nx][ny] != 0:
                pos[2] = 1
            elif i == 3 and data[nx][ny] != 0:
                pos[3] = 1
        else:
            continue

    if sum(pos) == 0:
        x -= 1
        data[x][y] = num
    elif sum(pos) == 1:
        if pos[0] == 1:
            y -= 1
            data[x][y] = num
        elif pos[1] == 1:
            y += 1
            data[x][y] = num
        elif pos[2] == 1:
            x += 1
            data[x][y] = num
        elif pos[3] == 1:
            x -= 1
            data[x][y] = num
    elif sum(pos) == 2:
        if pos[0] == 1 and pos[2] == 1:
            x += 1
            data[x][y] = num
        elif pos[0] == 1 and pos[3] == 1:
            y -= 1
            data[x][y] = num
        elif pos[1] == 1 and pos[2] == 1:
            y += 1
            data[x][y] = num
        elif pos[1] == 1 and pos[3] == 1:
            x -= 1
            data[x][y] = num
    num += 1

for i in range(n):
    for j in range(n):
        print(data[i][j], end = ' ')
        if data[i][j] == q:
            a = i+1
            b = j+1
    print()
print(a, b)