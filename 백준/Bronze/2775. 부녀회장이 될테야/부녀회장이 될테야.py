import sys
input = sys.stdin.readline
T = int(input())
# k층 n호에 몇 명이 살고있는지 저장할 dp 테이블
# k층의 n호에 살려면 자신의 아래(k-1)층의 1호부터 n호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다 => 규칙
# 0층부터 있고 각 층에는 1호부터 있다
dp = [[0 for _ in range(15)] for _ in range(15)]

# 0층의 i호에는 i명이 산다
for i in range(1, 15):
    dp[0][i] = i

for i in range(T):
    # k층
    k = int(input())
    # n호
    n = int(input())
    for j in range(1, k+1):
        for l in range(1, n+1):
            # 1호일 경우 j-1층의 1호에 사는 사람 수를 대입
            if l == 1:
                dp[j][l] = dp[j-1][1]
            # 그 외에 2~14호일 경우는 dp[j][l-1] + dp[j-1][l]
            # 같은 층의 바로 직전 호에 사는 사람 수 + 한 층 아래에 사는 같은 호 사람 수
            else:
                dp[j][l] = dp[j][l-1] + dp[j-1][l]
    print(dp[k][n])