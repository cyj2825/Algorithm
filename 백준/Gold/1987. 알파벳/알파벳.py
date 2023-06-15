# deque를 사용해서 풀면 시간초과 발생 -> set으로 변경
r, c = map(int, input().split())
# 알파벳 리스트 받기
data = [list(input()) for _ in range(r)]
# 상하좌우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
answer = 1

def BFS():
    global answer
    # 시작값과 알파벳 q에 넣기
    # set 함수를 사용하여 q에 이미 존재하는 알파벳은 들어갈 수 없도록 함
    q = set([(0, 0, data[0][0])])

    # q가 빌 때까지 반복
    while q:
        # 새로 이동한 칸에 적혀 있는 알파벳이 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 함으로 check 리스트 생성
        x, y, check = q.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < r and 0 <= ny < c and data[nx][ny] not in check:
                q.add((nx, ny, check + data[nx][ny]))
                answer = max(answer, len(check) + 1)

BFS()
print(answer)