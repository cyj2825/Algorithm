n = int(input())
num = 0
numSum = 0

for i in range(1, n+1):
    num = sum(map(int, str(i)))    # i의 각 자릿수를 더함
    numSum = num + i
    if numSum == n:
        print(i)
        break
    if i == n:
        print(0)