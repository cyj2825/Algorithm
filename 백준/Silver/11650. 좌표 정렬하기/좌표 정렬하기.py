# 백준 11650번 좌표 정렬하기
import sys
import heapq
input = sys.stdin.readline
n = int(input())
q = []

for i in range(n):
    x, y = map(int, input().split())
    heapq.heappush(q, (x, y))

for i in range(n):
    a,b = heapq.heappop(q)
    print(a, b)