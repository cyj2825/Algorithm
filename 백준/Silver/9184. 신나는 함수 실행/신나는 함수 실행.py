# 문제에서 주어진대로 함수를 작성하면 시간 초과 발생
import sys
input = sys.stdin.readline
a, b, c = 0, 0, 0
dp = [[[0 for _ in range(21)] for _ in range (21)] for _ in range (21)]

def w(a, b, c):
    # 0보다 작으면 1로 리턴
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    # 20보다 크면 모두 w(20, 20, 20)으로 통일
    # dp는 3차원 모두 0~20까지만 초기화하면 됨
    if a > 20 or b > 20 or c > 20:
        return w(20, 20, 20)
    # dp값이 존재하면 바로 리턴 => 구했던 것을 또 구하는 시간을 쓰지 않는다
    if dp[a][b][c]:
        return dp[a][b][c]
    if a < b < c:
        dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
    else:
        dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

    return dp[a][b][c]

while True:
    a, b, c = map(int, input().split())
    if a == -1 and b == -1 and c == -1:
        break
    print("w({}, {}, {}) = {}".format(a,b,c,w(a,b,c)))