from itertools import permutations
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
for i in permutations(data, m):
    print(*i)