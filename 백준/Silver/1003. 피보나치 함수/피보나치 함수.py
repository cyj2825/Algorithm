import sys
input = sys.stdin.readline
T = int(input())
# n은 40보다 작거나 같은 자연수 또는 0이므로 dp 테이블의 크기는 41
# dp[i][0]은 i값으로 fibonacci함수를 실행했을 때 0이 출력되는 횟수, dp[i][1]은 1이 출력되는 횟수
dp = [[0, 0] for _ in range(41)]
# 기본값 넣어주기
dp[0][0] = 1
dp[1][1] = 1

for i in range(T):
    n = int(input())
    for j in range(2, n+1):
        dp[j][0] = dp[j - 1][0] + dp[j - 2][0]
        dp[j][1] = dp[j - 1][1] + dp[j - 2][1]
    print(dp[n][0], dp[n][1])