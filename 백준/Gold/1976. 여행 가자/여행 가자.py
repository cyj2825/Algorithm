# 다시보기
# 유니온 파인드 사용
n = int(input())
# 여행 계획에 속한 도시의 수
m = int(input())
# 대표 노드 저장 리스트
main = [0]*(n+1)
for i in range(1, n+1):
    main[i] = i
city = [[0 for j in range(n+1)] for i in range(n+1)]
   
def find(a):
    if a == main[a]:
        return a
    else:
        main[a] = find(main[a])
        return main[a]
    
# 대표 노드끼리 연결    
def union(a,b):
    a = find(a)
    b = find(b)
    if a != b:
        main[b] = a

for i in range(1,n+1):
    city[i] = list(map(int, input().split()))
    # index가 1부터 시작하므로 0번째에 0 데이터 값 삽입 필요
    city[i].insert(0,0)

# 여행 계획 도시 저장 리스트    
route = list(map(int, input().split()))
# index가 1부터 시작하므로 0번째에 0 데이터 값 삽입 필요
route.insert(0,0)

for i in range(1,n+1):
    for j in range(1,n+1):
        # 도시가 연결되어 있으면 union 연산
        if city[i][j] == 1:
            union(i,j)
            
index = find(route[1])
# 연결 여부 저장 변수
isConnect = True
for i in range(2, len(route)):
    # route에 포함되는 노드들의 대표 노드가 모두 동일한지 확인 => 여행 계획 도시들이 1개의 대표 노드로 연결되어있어야함
    if index != find(route[i]):
        isConnect = False
        break
if isConnect:
    print("YES")
else:
    print("NO")