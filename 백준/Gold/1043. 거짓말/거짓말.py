# 유니온 파인드 사용
import sys
input = sys.stdin.readline
# 사람의 수, 파티의 수
n, m = map(int, input().split())
# 진실을 아는 사람 정보
truth = list(map(int, input().split()))
# 진실을 아는 사람의 수를 T에 저장하고 리스트에서는 삭제
T = truth[0]
del truth[0]
count = 0
# 대표 노드 저장 리스트
parent = [i for i in range(n+1)]
# 파티 정보 리스트 초기화
party = [[] for _ in range(m)]
# 파티 정보 저장
for i in range(m):
    party[i] = list(map(int, input().split()))
    del party[i][0]     # 파티에 참여하는 사람의 수는 삭제

# 자신이 속한 집합의 대표 노드를 찾는 연산
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

# 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
for i in range(m):
    # 앞에서 파티에 참여한 사람들의 총 수 값을 삭제했으므로 party[i][0]은 파티에 참여한 사람들 중 가장 앞에 있는 사람의 번호
    firstperson = party[i][0]
    # 맨 앞 사람을 제외하고 두 번째 사람부터 union연산
    for j in range(1, len(party[i])):
        union(firstperson, party[i][j])

# 각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없음
for i in range(m):
    isPossible = True
    firstperson = party[i][0]
    for j in range(T):
        if find(firstperson) == find(truth[j]):
            isPossible = False
            break
    if isPossible:
        count += 1
print(count)