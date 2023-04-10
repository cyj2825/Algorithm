# 다시보기
# 유니온 파인드 사용
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)     # 재귀함수가 이용될 때 꼭 필요
n, m = map(int, input().split())
# 대표 노드 저장 리스트
main = [0]*(n+1)

# find 연산
def find(a):
    # a가 대표 노드이면 a를 리턴
    if a == main[a]:
        return a
    else:
        # 재귀 함수 형태, a의 대표 노드 값을 find(main[a])값으로 변경
        main[a] = find(main[a])
        return main[a]

# union 연산, 대표 노드끼리 합치기
def union(a,b):
    a = find(a)
    b = find(b)
    if a != b:
        main[b] = a
        
# 두 원소가 같은 집합인지 확인
def check(a,b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    return False

# 대표 노드를 자기 자신으로 초기화
for i in range(n+1):
    main[i] = i

for i in range(m):
    v, a, b = map(int, input().split())
    if v == 0:
        union(a,b)
    else:
        if check(a,b):
            print("YES")
        else:
            print("NO")