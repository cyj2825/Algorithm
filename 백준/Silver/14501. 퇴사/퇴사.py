import sys
input = sys.stdin.readline
n = int(input())
# i부터 퇴사일까지 벌 수 있는 최대 수입
dp = [0] * (n+2)
# 상담에 필요한 일수
T = [0] * (n+1)
# 상담 완료 시 수입
P = [0] * (n+1)

for i in range(1, n+1):
    T[i], P[i] = map(int, input().split())

# 톱-다운 구현 방식 (n일부터 1일까지 내려가면서 dp 테이블 채우기)
for i in range(n, 0, -1):
    # i번째 상담을 퇴사일까지 끝낼 수 없을 때
    if i+T[i] > n+1:
        # i+1일부터 퇴사일까지 벌 수 있는 최대 수입
        dp[i] = dp[i+1]
    # i번째 상담을 퇴사일까지 끝낼 수 있을 때
    else:
        # i+1일부터 퇴사일까지 벌 수 있는 최대 수입과 i번째 상담 비용 + i번째 상담이 끝난 다음 날부터 퇴사일까지의 최대 수입 중 큰 값을 dp 테이블에 저장
        dp[i] = max(dp[i+1], dp[i+T[i]]+P[i])

# 1일부터 퇴사일까지 벌 수 있는 최대 수입을 출력해야 하기 때문에 dp[1]
print(dp[1])