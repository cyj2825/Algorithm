# 노드들 간의 거리가 1000m를 넘어서는 안됨! (박스에 맥주를 최대 20개까지 담을 수 있고 50m에 맥주 한 병씩을 마셔야 하기 때문)
from collections import deque
import sys
input = sys.stdin.readline

def BFS():
    q = deque()
    q.append([home[0], home[1]])
    # q가 빌 때까지 반복
    while q:
        x, y = q.popleft()
        # 절댓값 함수 abs
        if abs(fest[0] - x) + abs(fest[1] - y) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                store_x, store_y = store[i]
                if abs(store_x - x) + abs(store_y - y) <= 1000:
                    q.append([store_x, store_y])
                    visited[i] = 1
    print("sad")
    return

t = int(input())
for _ in range(t):
    # 맥주를 파는 편의점의 개수
    n = int(input())
    # 상근이네 집 x, y 좌표
    home = [int(x) for x in input().split()]
    store = []
    # 편의점의 위치
    for _ in range(n):
        x, y = map(int, input().split())
        store.append([x, y])
    # 펜타포트 락 페스티벌 위치
    fest = [int(x) for x in input().split()]
    # 편의점 방문 여부 체크하기 위한 리스트
    visited = [0 for _ in range(n)]
    BFS()