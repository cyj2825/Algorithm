import sys
input = sys.stdin.readline

A = list(map(str, input()))
A.sort(reverse=True)
for i in A:
    print(i, end='')