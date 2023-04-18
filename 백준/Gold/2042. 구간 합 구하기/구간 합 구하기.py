# 다시보기
# 백준 2042번 구간 합 구하기
# 세그먼트 트리 사용
import sys
input = sys.stdin.readline
# 수의 개수, 변경 횟수, 구간의 합 구하는 횟수
n, m, k = map(int, input().split())
# 트리의 높이
treeHeight = 0
# 리프 노드의 개수
x = n

# 트리의 높이 구하기 : 리프 노드의 개수를 2씩 나누어 가면서 높이 계산 (n <= 2 ** x을 만족하는 x를 구해야 하므로)
while x != 0:
    # 2를 나눈 몫을 x에 넣는다
    x //= 2
    treeHeight += 1

# 트리의 크기 : 2**(treeHeight+1)
treeSize = pow(2, treeHeight+1)
# 1차원 배열 트리 리스트 초기화
tree = [0] * (treeSize+1)
# 리프 노드 시작 인덱스값은 2 ** treeHeight
leafNodeStart = treeSize//2

# 리프 노드 데이터를 트리 리스트에 저장
for i in range(leafNodeStart, leafNodeStart+n):
    tree[i] = int(input())

# 인덱스 트리 생성 함수
def setTree(i):
    while i != 1:
        # i//2를 통해 부모 노드 = 왼쪽 자식 노드 + 오른쪽 자식 노드
        tree[i//2] += tree[i]
        i -= 1

# 값 변경 함수
def change(i, v):
    # 원래 데이터와 변경 데이터의 차이만큼 부모 노드로 올라가면서 변경
    diff = v - tree[i]
    while i > 0 :
        # 변경값 갱신
        tree[i] += diff
        # 한 칸 위 부모 노드 찾기 위해
        i //= 2

# 구간 합 함수
def rangeSum(s, e):
    partSum = 0

    # 질의값 구하기
    while s <= e:
        # 결과값이 1이라는 것은 어떤 노드의 자식 노드로 존재할 때 해당 노드는 오른쪽 자식 노드라는 의미
        # 해당 노드의 부모 노드는 필요없고 해당 노드는 독립 노드가 됨
        if s % 2 == 1:
            partSum += tree[s]
            s += 1
        # 결과값이 0이라는 것은 어떤 노드의 자식 노드로 존재할 때 해당 노드는 왼쪽 자식 노드라는 의미
        # 해당 노드의 부모 노드는 필요없고 해당 노드는 독립 노드가 됨
        if e % 2 == 0:
            partSum += tree[e]
            e -= 1
        s = s // 2
        e = e // 2
    return partSum

# 트리 생성, 트리 리스트 중 가장 큰 인덱스값부터 시작 => 위로 올라가면서 부모 노드를 채워줄 것이기 때문
setTree(treeSize - 1)

for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        # 주어진 질의 인덱스를 세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경
        change(b + leafNodeStart - 1, c)
    elif a == 2:
        # 주어진 질의 인덱스를 세그먼트 트리의 리프 노드에 해당하는 인덱스로 변경
        b = b + leafNodeStart - 1
        c = c + leafNodeStart - 1
        print(rangeSum(b, c))