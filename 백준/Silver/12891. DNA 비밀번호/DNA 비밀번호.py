S, P = map(int, input().split())
DNA = list(input())
check = list(map(int, input().split()))
dic = {'A': check[0], 'C': check[1], 'G': check[2], 'T': check[3]}
base = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
count = 0

for i in range(S-P+1):
    state = True
    if i == 0:
        for j in range(P):
            base[DNA[j]] += 1
    else:
        base[DNA[i+P-1]] += 1
        base[DNA[i-1]] -= 1

    for i in ('A', 'C', 'G', 'T'):
        if base[i] < dic[i]:
            state = False
            break
    if state:
        count += 1
print(count)