n = int(input())
# 2차원 리스트의 맵 정보 입력받기
dp = []
for i in range(n):
    dp.append(list(map(int, input().split())))

# dp[0]값은 하나이므로 무조건 가져야 한다
for i in range(1, n):
    for j in range(0,i+1):
        # 0열과 마지막 열은 선택 화살표가 하나이므로
        if j == 0:
            # 0열끼리 더하기
            dp[i][0] += dp[i-1][0]
        elif j == i:
            # 마지막 열끼리 더하기
            dp[i][j] += dp[i-1][j-1]
        # 그외의 열은 선택 화살표가 두 개이므로
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])
print(max(dp[n-1]))