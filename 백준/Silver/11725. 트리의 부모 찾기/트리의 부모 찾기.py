import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n = int(input())
# 연결된 트리 노드 저장 리스트
data = [[] for _ in range(n+1)]
# 각 노드의 부모 노드 저장 리스트
answer = [0] * (n+1)

# 연결된 트리 노드 값들 받아와 양방향으로 넣어주기
for _ in range(n-1):
    a, b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

# 재귀함수 사용
def DFS(a):
    for x in data[a]:
        if answer[x] == 0:
            answer[x] = a
            DFS(x)
# 루트 노드가 1이므로 루트 노드의 자식 노드들의 부모 노드는 당연히 1
# 그 자식 노들의 부모 노드도 DFS 함수(깊이 우선 탐색)로 찾음
for i in data[1]:
    answer[i] = 1
    DFS(i)

for i in range(2, n+1):
    print(answer[i])