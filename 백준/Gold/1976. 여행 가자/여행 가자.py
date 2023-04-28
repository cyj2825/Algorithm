# 유니온 파인드 사용
import sys
input = sys.stdin.readline
# 도시 개수
n = int(input())
# 여행 계획에 속한 도시들의 수
m = int(input())
# 도시 연결 리스트 초기화
dosi = [[0 for _ in range(n+1)] for _ in range(n+1)]
# 대표 노드 저장 리스트
parent = [i for i in range(n+1)]
# 도시 연결 데이터 저장
for i in range(1, n+1):
    dosi[i] = list(map(int, input().split()))
    # 인덱스가 1부터 시작이기 때문에 0번째에 0 데이터 삽입
    dosi[i].insert(0, 0)
# 여행 도시 정보 저장
route = list(map(int, input().split()))
# 인덱스가 1부터 시작이기 때문에 0번째에 0 데이터 삽입
route.insert(0, 0)

# 자신이 속한 집합의 대표 노드 찾는 연산
def find(a):
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]

# 각 노드가 속한 집합을 한 개로 합치는 연산
def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a

for i in range(1, n+1):
    for j in range(1, n+1):
        # 인접 행렬에서 도시가 연결되어 있으면 union 실행
        if dosi[i][j] == 1:
            union(i, j)

index = find(route[1])
isConnect = True
# 여행 계획 도시들이 1개의 대표 도시로 연결되어 있는지 확인, route[1] 값을 기준으로 진행
for i in range(2, len(route)):
    # route에 포함되는 노드들의 대표 노드가 모두 동일한지 확인한 후 isConnect값 저장 => 여행 계획 도시들이 1개의 대표 노드로 연결되어 있어야 함
    if index != find(route[i]):
        isConnect = False
        break
if isConnect:
    print("YES")
else:
    print("NO")