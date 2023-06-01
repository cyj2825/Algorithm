# 중복조합 사용
from itertools import combinations_with_replacement
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
data = sorted(list(map(int, input().split())))

for numbers in combinations_with_replacement(data, m):
    for num in numbers:
        print(num, end = ' ')
    print()