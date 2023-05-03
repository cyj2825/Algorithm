import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))
# 첫번째 인덱스부터 수열의 길이의 최댓값을 저장해 나갈 dp 테이블 초기화
dp = [0 for _ in range(n)]

for i in range(n):
    # A[i] 보다 이전의 값을 하나하나 탐색
    # 만약 이전의 값보다 A[i] 값이 더 크고 dp[i] 값이 더 작을 경우 dp[i] 값을 dp[j]로 업데이트 
    for j in range(i):
        if A[i] > A[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    dp[i] += 1
    
print(max(dp))