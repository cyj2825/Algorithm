# 다시보기
# 깊이 우선 탐색(DFS) 사용
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline
n, m = map(int, input().split())
# 그래프 데이터 저장 인접 리스트 초기화
A = [[] for _ in range(n+1)]
# 방문 기록 리스트 초기화
visited = [0] * (n+1)
count = 0

def DFS(v):
    visited[v] = 1
    for i in A[v]:
        if visited[i] == 0:    # 현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행(재귀 함수)
            DFS(i)
            
for _ in range(m):
    s, e = map(int, input().split())
    A[s].append(e)    # 방향 없는 그래프이므로 양쪽 모두에 값을 추가
    A[e].append(s)
    
for i in range(1,n+1):
    if visited[i] == 0:   # 연결 노드 중 방문하지 않은 노드만 탐색
        count += 1       # 연결 요소 개수 값 1 증가
        DFS(i)

print(count)