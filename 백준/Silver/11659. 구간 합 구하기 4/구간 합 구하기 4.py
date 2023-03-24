import sys
input = sys.stdin.readline
n, m = map(int, input().split())
datas = [0] + list(map(int, input().split()))
s = [0] * (n+1)
answer = 0

for i in range(1, n+1):
    s[i] = s[i-1] + datas[i]
for i in range(m):
    a, b = map(int, input().split())
    print(int(s[b] - s[a-1]))