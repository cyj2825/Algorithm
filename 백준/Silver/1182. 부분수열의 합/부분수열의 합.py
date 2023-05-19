# 조합을 이용한 브루트포스 방식
from itertools import combinations
import sys
input = sys.stdin.readline
n, s = map(int, input().split())
data = list(map(int, input().split()))
count = 0
# combinations 함수를 사용하여 data 배열에서 구성할 수 있는 모든 조합을 구해서 해당 조합의 총합이 구하고자 하는 s값과 같은지 확인
for i in range(1, n+1):
    com = combinations(data, i)

    for j in com:
        if sum(j) == s:
            count += 1

print(count)