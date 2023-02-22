n = int(input())
s = [int(input()) for _ in range(n)]
d = [0] * n

# 계단이 2개 이하일 때
if len(s) <= 2:
    print(sum(s))
# 계단이 3개 이상일 때
else:
    d[0] = s[0]
    d[1] = s[0] + s[1]
    for i in range(2, n):
        d[i] = max(d[i-3]+s[i-1]+s[i], d[i-2]+s[i])
    print(d[-1])