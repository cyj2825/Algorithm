import sys
# 시간을 줄이기 위해 재정의
# python에서 그냥 제공해주는 input보다 sys.stdin.readline으로 재정의할 때가 더 빠름
input = sys.stdin.readline
n = int(input())
# dp 테이블 초기화
dp = [0] * (n+2)
# 이미 아는 값은 미리 넣어준다
dp[1] = 1
dp[2] = 1
# dp 테이블의 규칙 찾음 => n자리 이친수 개수 = n-1자리 이친수 개수 + n-2자리 이친수 개수
for i in range(3, n+1):
    dp[i] = dp[i-1]+dp[i-2]
print(dp[n])