# 다시보기
# 플로이드-워셜 사용
import sys
input = sys.stdin.readline
n = int(input())     # 도시의 개수
m = int(input())     # 노선의 개수
distance = [[sys.maxsize for _ in range(n+1)] for _ in range(n+1)]

for i in range(1,n+1):   # 자기자신과의 거리는 0으로 초기화
    distance[i][i] = 0

for _ in range(m):
    s, e, p = map(int, input().split())
    # 시작점 s와 도착점 e로 가는 노선이 여러 개일 수도 있기 때문(즉 p값이 더 작은 것이 있을 수 있다)
    if distance[s][e] > p:
        distance[s][e] = p

# 플로이드-워셜 수행 for문
for k in range(1,n+1):
    for s in range(1, n+1):
        for e in range(1, n+1):
            if distance[s][e] > distance[s][k]+distance[k][e]:
                distance[s][e] = distance[s][k] + distance[k][e]

for i in range(1, n+1):
    for j in range(1, n+1):
        if distance[i][j] == sys.maxsize:
            print(0, end = ' ')
        else:
            print(distance[i][j], end = ' ')
    print()