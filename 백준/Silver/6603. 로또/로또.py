from itertools import combinations
import sys
input = sys.stdin.readline

while True:
    data = list(map(int, input().split()))
    if data[0] == 0:
        break
    else:
        for i in combinations(data[1:], 6):
            print(*i)
        print()