# 재귀 사용
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
data = sorted(list(map(int, input().split())))
result = []

def DFS(s):
    if len(result) == m:
        print(*result)
        return
    for i in range(s, n):
        result.append(data[i])
        DFS(i)
        result.pop()
        
DFS(0)