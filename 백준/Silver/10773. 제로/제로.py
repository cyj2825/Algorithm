import sys
input = sys.stdin.readline
n = int(input())
data = []

for i in range(n):
    a = int(input())
    if a == 0:
        data.pop()
    else:
        data.append(a)
if len(data) == 0:
    print(0)
else:
    print(sum(data))