# dp 문제
# 2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수 구하기
n = int(input())
# dp 테이블 초기화
dp = [0] * (n+2)
# 기본 정보 값 미리 넣기
dp[1] = 1
dp[2] = 2

# 규칙 찾기 -> dp[i] = dp[i-1] + dp[i-2]
for i in range(3, n+1):
    dp[i] = (dp[i-1] + dp[i-2]) % 10007

print(dp[n])