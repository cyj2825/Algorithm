import heapq
import sys
input = sys.stdin.readline
# 카드 묶음의 개수
n = int(input())
q = []

for _ in range(n):
    heapq.heappush(q, int(input()))

if len(q) == 1:
    print(0)
else:
    answer = 0
    while len(q) > 1:
        a = heapq.heappop(q)
        b = heapq.heappop(q)
        answer += a + b
        heapq.heappush(q, a + b)
        
    print(answer)