from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
# 양방향 노드 그래프 생성
data = [[] for _ in range(n+1)]
answer = []

for i in range(m):
    a, b = map(int, input().split())
    # 양방향이므로 a, b 모두에 넣어준다
    data[a].append(b)
    data[b].append(a)

def BFS(data, s):
    # s가 모든 사람과 케빈 베이컨 게임을 했을 때 나오는 단계의 합
    num = [0] * (n+1)
    q = deque()
    q.append(s)
    visited[s] = 1

    # q가 빌 때까지 반복
    while q:
        a = q.popleft()
        for i in data[a]:
            if visited[i] == 0:
                num[i] = num[a] + 1
                q.append(i)
                visited[i] = 1
    return sum(num)

for i in range(1, n + 1):
    # 계산하는 사람이 바뀔 때마다 visited 값이 초기화 되어야 하므로
    visited = [0 for _ in range(n + 1)]
    answer.append(BFS(data, i))
    
print(answer.index(min(answer)) + 1)