n = int(input())
scores = list(map(int, input().split()))
m = max(scores)
sum = sum(scores)

print(sum*100/m/int(n))