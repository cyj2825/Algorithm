import sys
input = sys.stdin.readline
n = int(input())

for i in range(n):
    a = list(input())
    count = 0
    for j in a:
        if j == '(':
            count += 1
        elif j == ')':
            count -= 1
        if count < 0:
            print('NO')
            break

    if count > 0:
        print('NO')
    elif count == 0:
        print('YES')
