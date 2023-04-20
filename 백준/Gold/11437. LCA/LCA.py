# 다시보기
# LCA 사용(빠르게 최소 공통 조상 구하기 방법 -> 일반적으로 최소 공통 조상 구하기 방법을 이용하면 시간 초과)
import sys
# BFS 사용하기 위해
from collections import deque
input = sys.stdin.readline
print = sys.stdout.write          # 이때 print는 무조건 str값으로 넣어야 한다
n = int(input())
# 트리 데이터 초기화
tree = [[0] for _ in range(n+1)]

# 인접 리스트에 데이터 저장, n-1줄까지 두 노드의 쌍을 준다고 하였으므로 0~n-2까지 반복
for _ in range(n-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

# 해당 노드의 부모 노드와 깊이(depth)를 기록하기 위해
# LCA를 사용하기 위해서는 인접 리스트, 깊이 리스트, 부모 리스트, 방문 여부 저장 리스트(BFS를 사용하기 때문) 필요
depth = [0] * (n+1)
visited = [False] * (n+1)
temp = 1
k = 0
# 최대 가능 depth(높이) 구하기, 이때 k는 트리의 깊이 > 2**k를 만족하는 최댓값
while temp <= n:
    temp <<= 1     # <<는 시프트 연산자로 1씩 증가되면 *2의 효과가 있음
    k += 1

# 1. 일반적으로 구하는 방법과 다른 점
# 부모 노드 저장 리스트가 이차원 배열, 기존에는 자신의 부모 노드만 저장해뒀지만 여기서는 2**k번째 위치의 부모 노드까지 저장해야 함
parent = [[0 for _ in range(n+1)] for _ in range(k+1)]

def BFS(node):
    q = deque()
    q.append(node)
    visited[node] = True
    level = 1       # 현재 트리 깊이
    now_size = 1    # 현재 깊이에서 트리 크기, 1로 초기화한 이유는 루트 노드의 깊이에서는 루트 노드 하나만 존재하여 트리 크기는 1이기 때문
    count = 0       # 현재 깊이 트리 크기만큼 while문을 돌고 level(즉, depth, 트리 깊이)을 변경하기 위해 사용

    while q:        # q가 빌 때까지 반복
        now_node = q.popleft()
        # now_node의 자식 노드를 탐색
        for next in tree[now_node]:
            if not visited[next]:
                visited[next] = True            # 방문했음을 기록
                q.append(next)                  # q에 데이터 삽입
                parent[0][next] = now_node      # next의 부모 노드에 now_node를 저장
                depth[next] = level             # 깊이 리스트에 next의 깊이를 현재 깊이 level로 저장
        count += 1
        # 현재 깊이 트리 크기만큼만 while문 돌고 level 변경
        if count == now_size:
            count = 0
            level += 1
            now_size = len(q)

# LCA 실행 함수
def executeLCA(a, b):
    # b 노드의 깊이가 a 노드이 깊이보다 작을 경우 swap, 밑에 코드로 depth를 맞추기 수월하게 하기 위해서
    if depth[a] > depth[b]:
        temp = a
        a = b
        b = temp

    # parent 리스트를 이용해 2의 제곱수로 이동
    # 두 노드의 depth를 동일하게 맞추기
    for i in range(k, -1, -1):
        if pow(2, i) <= depth[b] - depth[a]:
            if depth[a] <= depth[parent[i][b]]:
                b = parent[i][b]

    # parent 리스트를 이용해 2의 제곱수로 이동
    # 두 노드의 같은 조상이 나올 때까지 각 노드를 부모 노드로 변경
    for i in range(k, -1, -1):
        if a == b: break
        if parent[i][a] != parent[i][b]:
            a = parent[i][a]
            b = parent[i][b]
    LCA = a
    # 반복문이 종료 된 후 이동한 2개의 노드가 다른 노드라면 바로 위의 부모 노드가 최소 공통 조상
    if a != b:
        LCA = parent[0][LCA]
    return LCA

BFS(1)
# 2**k번째 부모 노드 계산 및 저장
for i in range(1, k+1):
    for j in range(1, n+1):           # 노드 개수만큼 반복
        # 부모 노드 리스트의 점화식
        parent[i][j] = parent[i-1][parent[i-1][j]]

m = int(input())
for _ in range(m):
    a, b = map(int, input().split())
    print(str(executeLCA(a, b)))
    print("\n")