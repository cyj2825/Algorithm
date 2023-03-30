n = int(input())
A = list(map(int, input().split()))
A.sort()
answer = 0

for i in range(1,n+1):
    answer += sum(A[0:i])
print(answer)