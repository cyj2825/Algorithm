import sys
input = sys.stdin.readline
n = int(input())
A = list(map(int, input().split()))
A.sort()
count = 0

for i in range(n):
    find = A[i]
    a = 0
    b = n-1
    while a < b:
        if A[a]+A[b] == find:
            if a != i and b != i:
                count += 1
                break
            elif a == i:
                a += 1
            elif b == i:
                b -= 1
        elif A[a]+A[b] < find:
            a += 1
        else:
            b -= 1
print(count)