# DFS 문제라고 생각하고 풀었지만 2번에서 런타임오류 발생
# 중복을 허용하지 않는 BFS로 다시 풀었음
from collections import deque
import sys
input = sys.stdin.readline
# F : 총 층수, S : 강호가 있는 층수, G : 스타트링크가 있는 층수, U : 위로 U층 이동, D : 아래로 D층 이동
F, S, G, U, D = map(int, input().split())
# G까지 이동하기 위해 각 층마다 눌러야 하는 버튼의 최솟값을 count에 저장
count = [-1 for _ in range(F+1)]

def BFS():
    q = deque()
    # 강호가 있는 층수를 맨 처음에 넣고 시작
    q.append(S)
    count[S] = 0
    # q가 빌 때까지
    while q:
        x = q.popleft()
        if x == G:
            return count[x]
        else:
            # 이동 가능한 경우는 위로 U층 올라가는 것, 아래로 D층 내려가는 것
            for i in (x + U, x - D):
                if 0 < i <= F and count[i] == -1:
                    # 버튼 누른 횟수 갱신
                    count[i] = count[x] + 1
                    q.append(i)
    # 엘리베이터로 G층을 갈 수 없을 경우 해당 값 return
    return "use the stairs"

print(BFS())