import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

n = int(input())
m = int(input())
# 그래프 데이터 저장 인접 리스트 초기화
A = [[] for _ in range(n+1)]
# 방문 기록 리스트 초기화
visited = [0] * (n+1)

def DFS(v):
    visited[v] = 1
    for i in A[v]:
        if visited[i] == 0:
            DFS(i)
            
for _ in range(m):
    s, e = map(int, input().split())
    A[s].append(e)    # 방향 없는 그래프이므로 양쪽 모두에 값을 추가
    A[e].append(s)

DFS(1)
print(sum(visited)-1)