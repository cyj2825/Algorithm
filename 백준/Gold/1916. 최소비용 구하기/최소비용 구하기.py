# 다익스트라 사용
import sys
from queue import PriorityQueue
input = sys.stdin.readline

n = int(input())
m = int(input())
# 에지 데이터 저장 인접 리스트
data = [[] for _ in range(n+1)]
# 거리 저장 리스트, 충분히 큰 수로 초기화
distance = [sys.maxsize] * (n+1)
# 방문 여부 저장 리스트
visited = [False] * (n+1)

# 버스의 정보 data에 넣기
for i in range(m):
    s, e, w = map(int, input().split())
    data[s].append((e,w))

def dijkstra(a,b):
    q = PriorityQueue()
    # 우선순위 큐에 데이터를 최단 거리, 노드 순으로 삽입
    q.put((0, a))
    distance[a] = 0

    while q.qsize() > 0:     # 큐가 빌 때까지 계속 반복
        now = q.get()
        now_v = now[1]
        if not visited[now_v]:
            visited[now_v] = True
            for i in data[now_v]:
                # i 노드을 아직 방문하지 않았고 i 노드의 최단 거리보다 현재 선택 노드 최단 거리 + 비용이 작을 경우
                if not visited[i[0]] and distance[i[0]] > distance[now_v] + i[1]:
                    distance[i[0]] = distance[now_v] + i[1]
                    q.put((distance[i[0]], i[0]))
    # 도착점의 최종 거리 리턴
    return distance[b]
a, b = map(int,input().split())
print(dijkstra(a, b))