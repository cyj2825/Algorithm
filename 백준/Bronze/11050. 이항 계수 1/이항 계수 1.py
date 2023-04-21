# 조합 점화식을 이용하여 풀기
import sys
input = sys.stdin.readline
n, k = map(int, input().split())
# DP 리스트 초기화
D = [[0 for _ in range(n+1)] for _ in range(n+1)]

for i in range(n+1):
    D[i][1] = i         # i개에서 1개 선택하는 경우의 수 i개
    D[i][0] = 1         # i개에서 1개도 선택하지 않는 경우의 수 1개
    D[i][i] = 1         # i개에서 모두 선택하는 경우의 수 1개

# D를 모두 채워줌
for i in range(2, n+1):
    for j in range(1, i):       # 고르는 수의 개수가 전체 개수를 넘을 수 없으므로
        # 조합 기본 점화식
        D[i][j] = D[i-1][j] + D[i-1][j-1]

print(D[n][k])