# backtracking 문제
# combinations 사용
from itertools import combinations
import sys
input = sys.stdin.readline
L, C = map(int, input().split())
data = list(map(str, input().split()))
data.sort()

for i in combinations(data, L):
    count1, count2 = 0, 0
    for j in i:
        if j in ('a', 'e', 'i', 'o', 'u'):
            count1 += 1
        else:
            count2 += 1
    if count1 >= 1 and count2 >= 2:
        print(*i, sep='')