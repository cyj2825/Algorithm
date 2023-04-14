# 다시보기
# 백준 9663번 N-Queen
# 백트래킹
# 퀸이 놓인 위치를 기록하기 위해 2차원 배열을 사용할 것이 아니라 1차원 배열 인덱스, 값을 통해 구할 수 있음
# data[i] = j => i행, j열
n = int(input())
# data 리스트에는 0행에 어떤 열에 퀸이 들어갔고 1행에는 어떤 열에 퀸이 들어갔다는 식의 퀸이 들어간 각 행과 열의 값을 가지고 있음
# 즉 퀸이 있는 위치만 저장
data = [0] * n
answer = 0
# 체스판 방문 여부 리스트
visited = [False] * n

# 지금까지 저장해놓은 이전의 퀸의 위치와 현재 넣으려고 하는 퀸의 위치가 서로 공격할 수 없는 위치인지 체크하는 함수
def check(x):
    for i in range(x):
        # 퀸이 서로 공격할 수 없으려면 같은 행, 같은 열, 대각선(각 행의 차와 각 열의 차가 같을 때)이 아니여야 함
        if data[x] == data[i] or abs(data[x]-data[i]) == abs(x-i):
            return False
    return True

def n_queen(x):
    global answer
    if x == n:
        answer += 1
        return
    else:
        for i in range(n):
            if visited[i]:
                continue
            # x행, i열에 퀸을 놓겠다
            data[x] = i
            if check(x):             # 퀸을 놓을 수 있는 자리 즉 True 값을 반환하면
                visited[i] = True    # 퀸을 놓는다
                # 다음 행에 놓은 퀸이 자리를 찾으러 재귀함수 호출
                n_queen(x+1)
                visited[i] = False   # 재귀 탐색 후 퀸을 n개 놓을 수 없다면 퀸을 놓지 않는 것으로 초기화 후 다른 열을 탐색

n_queen(0)
print(answer)