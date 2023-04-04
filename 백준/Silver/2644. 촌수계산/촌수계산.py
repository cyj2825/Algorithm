# 다시보기
# 너비 우선 탐색 사용
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
# A, B는 촌수를 계산해야 하는 서로 다른 사람의 번호
A, B = map(int, input().split())
m = int(input())
# 그래프 데이터 저장 인접 리스트 초기화
graph = [[] for _ in range(n+1)]
# 촌수를 의미하는 탐색 depth
visited = [0] * (n+1)

for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def BFS(a, b):
    myQueue = deque([a])
    while myQueue:      # myQueue 값이 빌 때까지 while문 반복
        node = myQueue.popleft()   # deque의 가장 왼쪽에 있는 원소를 deque에서 제거하고, 그 값을 리턴
        if node == b:
            return visited[b]
        for i in graph[node]:
            if visited[i] == 0:
                myQueue.append(i)
                visited[i] = visited[node] + 1
    return -1
                
print(BFS(A, B))
