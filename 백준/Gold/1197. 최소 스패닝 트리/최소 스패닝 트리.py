# 다시보기
# MST 사용
import sys
# PriorityQueue보다 heapq가 빠르고 (w, s, e)의 값 들어가는 것도 확인했으므로 heapq 쓰자!
import heapq
input = sys.stdin.readline
n, m = map(int, input().split())
# 에지 정보를 저장할 힙 큐
q = []
# 유니온 파인드 리스트(대표 노드 저장 리스트)
parent = [0] * (n+1)

# 유니온 파인드용 리스트 초기화
for i in range(n+1):
    parent[i] = i

for i in range(m):
    s, e, w = map(int, input().split())
    heapq.heappush(q, (w, s, e))

# find 연산
def find(a):
    # a가 대표 노드이면 리턴 a
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])    # 재귀함수 형태
        return parent[a]
    
# union 연산
def union(a, b):
    # a와 b의 대표 노드 찾기
    a = find(a)
    b = find(b)
    # 두 원소의 대표 노드끼리 연결
    if a != b:
        parent[b] = a
        
# MST 실행
useEdge = 0     # 사용한 에지 수 저장 변수
result = 0

while useEdge < n - 1:
    w, s, e = heapq.heappop(q)
    # 같은 부모가 아닌 경우에만 연결 => 사이클이 발생하면 안되므로
    if find(s) != find(e):
        union(s, e)
        # 에지의 가중치값 더하기
        result += w
        useEdge += 1

print(result)