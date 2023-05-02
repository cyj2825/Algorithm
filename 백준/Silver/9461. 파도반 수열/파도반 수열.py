import sys
input = sys.stdin.readline
# 테스트 케이스의 개수 T
T = int(input())
# dp 테이블 초기화
P = [0] * 101
P[1] = 1
P[2] = 1
P[3] = 1
for _ in range(T):
    n = int(input())
    if n > 3:
        for i in range(4, n+1):
            P[i] = P[i-3] + P[i-2]
    print(P[n])