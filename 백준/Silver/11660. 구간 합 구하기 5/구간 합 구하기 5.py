import sys

input = sys.stdin.readline
n, m = map(int, input().split())
# 초기화
datas = [[0]*(n+1)]
D = [[0]*(n+1) for _ in range(n+1)]    # 합 배열 D
answer = 0

for i in range(n):
    # (1, 1) 값에 맞춰 넣기 위해 앞에 [0]을 붙여 받아옴
    datas_row = [0] + [int(a) for a in input().split()]
    datas.append(datas_row)
    
# 합 배열 구하기
for i in range(1, n+1):
    for j in range(1, n+1):
        D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + datas[i][j]

# 질의 결과값 출력하기
for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    answer = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1]
    print(answer)