# 다시보기
# 다익스트라 사용

# 제거될 때 가장 작은 값이 제거되는 우선순위 큐 사용
from queue import PriorityQueue
import sys
input = sys.stdin.readline
# 노드의 개수 V, 에지의 개수 E
V, E = map(int, input().split())
s = int(input())   # 출발노드
# 에지 데이터 저장 인접 리스트
data = [[] for _ in range(V+1)]
q = PriorityQueue()
# 방문 여부 리스트
visited = [False]*(V+1)
# 거리 저장 리스트, 충분히 큰 수로 초기화
distance = [sys.maxsize]*(V+1)

for _ in range(E):
    u, v, w = map(int, input().split())
    data[u].append((v,w))

distance[s] = 0
q.put((0, s))   # s를 시작점으로 설정

while q.qsize() > 0:        # 큐가 빌 때까지 계속 반복
    now = q.get()
    now_v = now[1]          # 현재 노드 값
    if visited[now_v]:      # 이미 방문한 노드이면 아래 코드 실행 안하고 다시 앞으로 감
        continue
    visited[now_v] = True   # 해당 노드의 visited 값을 방문한 값 True로 변경
    # 현재 노드에 존재하는 에지 꺼내기
    for i in data[now_v]:
        next = i[0]
        value = i[1]
        if distance[next] > distance[now_v] + value:   # 최소 거리
            distance[next] = distance[now_v] + value
            # 가중치가 정렬 기준이므로 순서를 가중치, 목표 노드 순으로 우선순위 큐 설정
            q.put((distance[next], next))
            
for i in range(1, V+1):
    if visited[i]:
        print(distance[i])
    else:
        print("INF")