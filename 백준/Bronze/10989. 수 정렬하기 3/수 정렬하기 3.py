# 다시보기
# 계수 정렬 사용
import sys
input = sys.stdin.readline
n = int(input())
# 카운팅 정렬 리스트
count = [0] * 10001

for i in range(n):
    count[int(input())] += 1
    
for i in range(10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)