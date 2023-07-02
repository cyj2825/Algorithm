def solution(x, y, n):
    answer = 0
    MAX = 1e9
    # 큰 값으로 초기화
    dp = [MAX] * (y + 1)
    # 가장 처음 값인 x는 아직 연산이 한 번도 진행되지 않았으므로 0을 넣는다
    dp[x] = 0
    for i in range (x, y + 1):
        # 현재 계산하는 값이 MAX일 경우 도달할 수 없는 수이기 때문에 continue
        if dp[i] == MAX:
            continue
        # 현재까지 도달하는데 연산 수 + 1과 도달할 수에 저장된 값을 비교하여 작은 값을 현재 연산 수로 저장
        if i + n <= y:
            dp[i + n] = min(dp[i + n], dp[i] + 1)
        if i * 2 <= y:
            dp[i * 2] = min(dp[i * 2], dp[i] + 1)
        if i * 3 <= y:
            dp[i * 3] = min(dp[i * 3], dp[i] + 1)
    # 연산수를 구해야 하는 최종값이 MAX일 경우는 x를 y로 만들 수 없는 경우이므로 -1를 return
    if dp[y] == MAX:
        return -1
    return dp[y]
