n = int(input())
S = [list(map(int, input().split())) for _ in range(n)]
visited = [False for _ in range(n)]
answer = int(1e9)

def DFS(num, idx):
    global answer
    if num == n//2:
        power1, power2 = 0, 0
        for i in range(n):
            for j in range(n):
                if visited[i] and visited[j]:
                    power1 += S[i][j]
                elif not visited[i] and not visited[j]:
                    power2 += S[i][j]
        answer = min(answer, abs(power1-power2))
        return

    for i in range(idx, n):
        if not visited[i]:
            visited[i] = True
            DFS(num+1, i+1)
            visited[i] = False

DFS(0, 0)
print(answer)