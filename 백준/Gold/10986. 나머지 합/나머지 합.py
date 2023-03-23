import sys
input = sys.stdin.readline

n, m = map(int, input().split())
# 원본 수열 A
A = list(map(int, input().split()))
# 합 배열
S = [0] * n
# 같은 나머지의 인덱스를 카운트하는 리스트
C = [0] * m
answer = 0

S[0] = A[0]
for i in range(1, n):
    S[i] = S[i-1] + A[i]
    
for i in range(n):
    r = S[i] % m   # 합 배열을 m으로 나눈 나머지 값
    if r == 0:
        answer += 1
    C[r] += 1

for i in range(m):
    if C[i] > 1:
        answer += C[i]*(C[i]-1) // 2

print(answer)