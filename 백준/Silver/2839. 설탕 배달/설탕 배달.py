n = int(input())
# dp 테이블 초기화
dp = [0] * 5001
# 기본값 넣기
dp[3], dp[4], dp[5] = 1, -1, 1

for i in range(6, n+1):
    if dp[i-5] != -1 and dp[i-5] != 0:
        dp[i] = dp[i-5] + 1
    elif dp[i-3] != -1 and dp[i-3] != 0:
        dp[i] = dp[i-3] + 1
    else:
        dp[i] = -1

print(dp[n])