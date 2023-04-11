# 벨만 포드 사용
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
edges = []                           # 에지 정보 저장 리스트
distance = [sys.maxsize] * (n+1)     # 거리 리스트, 첫번째 노드는 인덱스 0에 넣어주는게 아니라 1에 넣어줄 것

# 에지 데이터 저장
for i in range(m):
    s, e, t = map(int, input().split())
    edges.append((s, e, t))

# 벨만 포드 수행
distance[1] = 0    # 시작점은 거리가 0이 되도록
for _ in range(n-1):    # 최단 거리 구해짐
    for s, e, t in edges:
        if distance[s] != sys.maxsize and distance[e] > distance[s] + t:
            distance[e] = distance[s] + t

# 음수 사이클 확인
mCycle = False
for s, e, t in edges:    # 음수 사이클 존재 여부 확인
    if distance[s] != sys.maxsize and distance[e] > distance[s] + t:
        mCycle = True
        break

if not mCycle:
    for i in range(2, n+1):
        if distance[i] != sys.maxsize:
            print(distance[i])
        else:
            print(-1)
else:
    print(-1)