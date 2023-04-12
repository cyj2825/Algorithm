# 백준 11651번 좌표 정렬하기2
# heapq 사용
import sys
import heapq
input = sys.stdin.readline
n = int(input())
q = []

for i in range(n):
    x, y = map(int, input().split())
    heapq.heappush(q, (y, x))

for i in range(n):
    b, a = heapq.heappop(q)
    print(a, b)