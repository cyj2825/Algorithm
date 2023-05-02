import sys
input = sys.stdin.readline
n = int(input())
# dp 테이블 초기화
dp = [0] * (n+2)
dp[1] = 1
dp[2] = 2

# dp 테이블의 규칙 찾음 => n자리 가능한 2진 수열 개수 = n-1자리 가능한 2진 수열 개수 + n-2자리 가능한 2진 수열 개수
for i in range(3, n+1):
    dp[i] = (dp[i-1] + dp[i-2]) % 15746

print(dp[n])