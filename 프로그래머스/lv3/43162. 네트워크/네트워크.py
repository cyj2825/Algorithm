from collections import deque
def solution(n, computers):
    # 행만을 생각하고 진행해보자
    visited = [False for _ in range(n)]
    answer = 0
    
    def BFS(a):
        nonlocal n, visited
        q = deque()
        q.append(a)
        visited[a] = True
        
        # q가 빌 때까지
        while q:
            x = q.popleft()
            visited[x] = True
            for i in range(n):
                if computers[x][i] == 1 and x != i:
                    if not visited[i]:
                        q.append(i)

    for i in range(n):
        if not visited[i]:
            BFS(i)
            answer += 1
    return answer