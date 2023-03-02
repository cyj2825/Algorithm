from itertools import product

n, m = map(int, input().split())
data = [str(i) for i in range(1, n+1)]

for j in list(product(data, repeat=m)):
    print(' '.join(j))