# 백트래킹 문제
n, m = map(int, input().split())
a = []

def dfs(start):
    if len(a) == m:
        print(' '.join(map(str,a)))
        return
    for i in range(start, n+1):
        a.append(i)
        dfs(i)
        a.pop()
dfs(1)