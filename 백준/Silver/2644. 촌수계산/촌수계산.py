import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

n = int(input())
A = [[] for _ in range(n+1)]
a, b = map(int, input().split())
m = int(input())

def DFS(v):
    for i in A[v]:
        if check[i] == 0:
            check[i] = check[v]+1
            DFS(i)
            
for _ in range(m):
    s, e = map(int, input().split())
    A[s].append(e)
    A[e].append(s)
    
check = [0]*(n+1)
DFS(a)
print(check[b] if check[b] > 0 else -1)