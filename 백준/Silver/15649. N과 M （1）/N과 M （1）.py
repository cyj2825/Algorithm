from itertools import permutations
n, m = map(int, input().split())
num = [str(i) for i in range(1, n+1)]

# 순열
for j in list(permutations(num, m)):
    print(' '.join(j))