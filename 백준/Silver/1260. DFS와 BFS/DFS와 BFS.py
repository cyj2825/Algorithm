# 다시보기
import sys
from collections import deque
sys.setrecursionlimit(10000)
input = sys.stdin.readline

n, m, start = map(int, input().split())
# 그래프 데이터 저장 인접 리스트 초기화
A = [[] for _ in range(n+1)]

for _ in range(m):
    s, e = map(int, input().split())
    A[s].append(e)
    A[e].append(s)
    
for i in range(n+1):
    A[i].sort()       # 번호가 작은 노드부터 방문하기 위해 정렬
    
def DFS(v):
    visited[v] = 1
    print(v, end = ' ')
    for i in A[v]:
        if visited[i] == 0:
            DFS(i)
            
# BFS할 때는 큐를 사용해야 함
def BFS(v):
    myQueue = deque()
    myQueue.append(v)
    visited[v] = 1
    while myQueue:     # 큐 자료구조에 값이 없을 때까지 반복
        node = myQueue.popleft()    # popleft()는 리스트의 pop(0)과 같은 기능, 리스트의 pop()의 경우는 마지막 값을 꺼내는 것
        print(node, end = ' ')
        for i in A[node]:
            if visited[i] == 0:
                visited[i] = 1
                myQueue.append(i)
        

# 방문 기록 리스트 초기화
visited = [0] * (n+1)
DFS(start)   # DFS 결과값 출력
print()

# 방문 기록 리스트 초기화
visited = [0] * (n+1)
BFS(start)   # BFS 결과값 출력