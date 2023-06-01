from itertools import combinations
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
data = sorted(list(map(int, input().split())))
for numbers in combinations(data, m):
    for num in numbers:
        print(num, end= ' ')
    print()