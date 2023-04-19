import sys
input = sys.stdin.readline
m, n = map(int, input().split())

if m == 2:
    print(2)
elif n < m:
    print(n*2-1)
elif m <= n:
    print(m*2-2)