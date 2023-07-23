import sys
input = sys.stdin.readline
# 인접한 세로선 사이에는 가로선을 놓을 수 있음
# h : 각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수
n, m, h = map(int, input().split())
# 방문리스트
visited = [[False] * (n+1) for _ in range(h+1)]
data = []
for _ in range(m):
    a, b = map(int, input().split())
    visited[a][b] = True
answer = 4

def check():
    for i in range(1, n+1):
        now = i
        for j in range(1, h+1):
            if visited[j][now-1]:
                now -= 1
            elif visited[j][now]:
                now += 1
        if now != i:
            return False
    return True

def DFS(depth, idx):
    global answer
    # 가로선을 정답보다 많이 만든 경우 확인 필요 x
    if depth >= answer:
        return
    # i번 세로선의 결과가 i번이 나오는지 체크
    if check():
        answer = depth
        return

    for c in range(idx, len(data)):
        x, y = data[c]
        if not visited[x][y-1] and not visited[x][y+1]:
            visited[x][y] = True
            DFS(depth+1, c+1)
            visited[x][y] = False

for i in range(1,h+1):
    for j in range(1, n):
        if not visited[i][j-1] and not visited[i][j] and not visited[i][j+1]:
            data.append([i, j])
            
DFS(0, 0)
print(answer if answer < 4 else -1)