# 백트래킹 문제
# m개의 치킨집을 선택하는 모든 조합에 대해 도시의 치킨 거리 구하기
from itertools import combinations
import sys
input = sys.stdin.readline
# m은 도시에 있는 치킨집 제한 개수
n, m = map(int, input().split())
# r과 c는 1부터 시작하긴 하지만 어차피 두 위치 간의 거리를 구하는 것이므로 0 ~ n-1까지 해도 됨
data = [list(map(int, input().split())) for _ in range(n)]
home = []
chicken = []
answer = 1e9

# 집과 치킨집의 위치 좌표를 각각 home, chicken 리스트에 넣어 저장
for i in range(n):
    for j in range(n):
        if data[i][j] == 1:
            home.append([i, j])
        elif data[i][j] == 2:
            chicken.append([i, j])

# 조합을 이용하여 m개의 치킨집 선택
for chi in combinations(chicken, m):
    # 도시의 치킨 거리
    temp = 0
    for a, b in home:
        # 각 집마다의 치킨 거리
        value = 1e9
        for i in range(m):
            value = min(value, abs(a - chi[i][0]) + abs(b - chi[i][1]))
        # 조합을 이용하여 구한 m개의 치킨집에 해당하는 치킨 거리 합 구하기
        temp += value
    # 조합을 이용하여 구한 m개의 치킨집에 해당하는 치킨 거리 합 중 작은 값 구하기
    answer = min(answer, temp)
print(answer)