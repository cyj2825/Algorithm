# 다시보기
import sys
input = sys.stdin.readline
n = int(input())
# tree를 딕셔너리 형태로 선언 => 트리의 노드 값이 A, B, C, D이므로
tree = {}

for _ in range(n):
    root, left, right = input().split()
    # 딕셔너리 tree 루트값에 왼쪽자식노드, 오른쪽자식노드 값들을 차례로 넣음
    tree[root] = [left, right]

# 전위 순회 함수, 루트-왼쪽-오른쪽
def preOrder(node):
    if node == '.':             # 자식 노드가 없는 경우
        return
    print(node, end = '')       # 현재 노드 출력
    preOrder(tree[node][0])     # 왼쪽 탐색
    preOrder(tree[node][1])     # 오른쪽 탐색

# 중위 순회 함수, 왼쪽-루트-오른쪽
def inOrder(node):
    if node == '.':
        return
    inOrder(tree[node][0])      # 왼쪽 탐색
    print(node, end = '')       # 현재 노드 출력
    inOrder(tree[node][1])      # 오른쪽 탐색

# 후위 순회 함수, 왼쪽-오른쪽-루트
def postOrder(node):
    if node == '.':
        return
    postOrder(tree[node][0])    # 왼쪽 탐색
    postOrder(tree[node][1])    # 오른쪽 탐색
    print(node, end='')         # 현재 노드 출력

# 루트 노드가 A이므로 전위, 중위, 후위 순회할 때마다 맨 처음 루트 노드인 A를 넣어준다
preOrder('A')
print()
inOrder('A')
print()
postOrder('A')