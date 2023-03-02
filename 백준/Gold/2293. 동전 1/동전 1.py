n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
dp = [0] * (k+1)
dp[0]=1 # 동전이 하나만 쓰일 때를 위함

for i in coin:    # 각 코인의 종류를 모두 순회
    for j in range(i,k+1):     # 합이 j원이 되는 경우가 있다면 리스트 dp에 저장하기 위함
        dp[j] += dp[j-i]
print(dp[k])   # 합이 k원이 되는 경우의 수