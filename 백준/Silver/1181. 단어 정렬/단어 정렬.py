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
    # 입력 받은 s 값이 a 리스트에 존재하는지 확인 -> 존재할 경우 push하지 않는다
    if s in a:
        continue
    else:
        a.append(s)
        heapq.heappush(q, (len(s) - 1, s[:-1]))

# 입력 받은 s 값 중 중복값이 존재하여 q의 값이 n이 아닐 수 있으므로 0~len(q)-1만큼 반복
for i in range(len(q)):
    a, answer = heapq.heappop(q)
    print(answer)