import heapq
import sys
input = sys.stdin.readline
print = sys.stdout.write
n = int(input())
q = []
for i in range(n):
    x = int(input())
    if x == 0:
        if len(q) == 0:
            print('0\n')
        else:
            print(str(heapq.heappop(q))+'\n')
    else:
        heapq.heappush(q, x)