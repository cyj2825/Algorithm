# LCA 사용
import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n = int(input())
    # 각 노드의 부모 노드 저장
    parent = [0 for _ in range(n+1)]
    for _ in range(n-1):
        p, c = map(int, input().split())
        # 부모 노드 저장=> 한 줄에 두 개의 숫자 A B 가 순서대로 주어지는데, 이는 A가 B의 부모라는 뜻이라고 했으므로
        parent[c] = p
    a, b = map(int, input().split())
    # 앞에 0이 없으면 런타임 에러 발생 => 리스트 범위가 넘어가기 때문
    a_list = [0, a]
    b_list = [0, b]
    # 각 노드의 부모 노드가 루트일 때까지 모두 저장
    # a_list, b_list 모두 맨 끝은 루트 노드일 것 (a, 부모 노드, 부모 노드의 부모 노드, .... 루트 노드)
    while parent[a]:            # 루트 노드의 parent 값은 0이므로 종료. 그 이전 값은 계속 0이 아닌 값
        a_list.append(parent[a])
        a = parent[a]

    while parent[b]:            # 루트 노드의 parent 값은 0이므로 종료. 그 이전 값은 계속 0이 아닌 값
        b_list.append(parent[b])
        b = parent[b]
    count = 1       # 리스트의 맨 마지막 값의 인덱스는 -1이므로 -1부터 비교 시작
    while a_list[-count] == b_list[-count]:
        count += 1
    # 서로 다른 값을 갖는 순간 바로 위 부모 노드가 가장 가까운 조상 노드
    print(a_list[-count+1])