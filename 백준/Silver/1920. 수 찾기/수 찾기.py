import sys
input = sys.stdin.readline
n = int(input())
# 탐색 시간을 줄이기 위해 set함수로 받는다
A = set(map(int, input().split()))
m = int(input())
M = list(map(int, input().split()))

for i in M:
    if i in A:
        print(1)
    else:
        print(0)