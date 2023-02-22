from itertools import combinations
n, m = map(int, input().split())
data = [str(i) for i in range(1,n+1)]

for j in list(combinations(data, m)):
    print(" ".join(j))