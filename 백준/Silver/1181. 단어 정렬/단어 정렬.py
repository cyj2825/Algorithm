# 백준 1181번 단어 정렬
# heapq로 도전!
import sys
import heapq
input = sys.stdin.readline
n = int(input())
q = []
a = []
for i in range(n):
    s = input()
    if s in a:
        continue
    else:
        a.append(s)
        heapq.heappush(q, (len(s) - 1, s[:-1]))

for i in range(len(q)):
    a, answer = heapq.heappop(q)
    print(answer)