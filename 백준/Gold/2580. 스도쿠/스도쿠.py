# 백트래킹 문제 (완전 탐색)
import sys
input = sys.stdin.readline
data = [list(map(int, input().split())) for _ in range(9)]
blank = []

# data의 값이 0인 x, y값을 blank 리스트에 저장
for i in range(9):
    for j in range(9):
        if data[i][j] == 0:
            blank.append((i, j))

def check(i, j, n):
    # i, j 값이 0 ~ 2이면 0, 3 ~ 5이면 3, 6 ~ 8이면 6의 값을 갖도록
    x = i // 3 * 3
    y = j // 3 * 3
   
    for k in range(9):
        # 가로줄 탐색
        if data[i][k] == n:
            return False
        # 세로줄 탐색
        if data[k][j] == n:
            return False
        # 3*3 정사각형 탐색
        if data[x + k // 3][y + k % 3] == n:
            return False
    return True

# 백트래킹 완전 탐색
def DFS(idx):
    # blank 안에 있는 모든 값들을 모두 탐색했을 경우 스도쿠 배열 모두 출력하고 종료
    if idx == len(blank):
        for i in range(9):
            # 리스트 값 unpacking
            print(*data[i])
        exit(0)
    x, y = blank[idx]
    for i in range(1, 10):
        if check(x, y, i):
            data[x][y] = i
            # 다음 찾아야 하는 data의 0값으로 넘어감
            DFS(idx + 1)
            # 초기화 -> 정답이 없을 경우
            data[x][y] = 0
DFS(0)