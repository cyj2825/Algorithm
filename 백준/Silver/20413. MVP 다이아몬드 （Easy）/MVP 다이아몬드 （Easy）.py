# 다시보기
# 백준 20413번 MVP 다이아몬드(Easy)
import sys
input = sys.stdin.readline
n = int(input())
# 주의할 점은 한 번 달성한 MVP 등급은 줄어들지 않는다는 것
# S, G, P, D의 등급 기준액을 리스트로 받기
s, g, p, d = list(map(int, input().split()))
sum = 0
# 전 달의 과금액을 pre에 넣어 기록
pre = 0

rank = input()
for i in range(n):
    if rank[i] == 'B':
        # sum 값은 rank[i]의 등급 기준액-1-전 달의 과금액
        sum += s-1-pre
        # 전 달의 과금액은 rank[i]의 등급 기준액-1-전전 달의 과금액
        pre = s-1-pre
    elif rank[i] == 'S':
        # sum 값은 rank[i]의 등급 기준액-1-전 달의 과금액
        sum += g-1-pre
        # 전 달의 과금액은 rank[i]의 등급 기준액-1-전전 달의 과금액
        pre = g-1-pre
    elif rank[i] == 'G':
        # sum 값은 rank[i]의 등급 기준액-1-전 달의 과금액
        sum += p-1-pre
        # 전 달의 과금액은 rank[i]의 등급 기준액-1-전전 달의 과금액
        pre = p-1-pre
    elif rank[i] == 'P':
        # sum 값은 rank[i]의 등급 기준액-1-전 달의 과금액
        sum += d-1-pre
        # 전 달의 과금액은 rank[i]의 등급 기준액-1-전전 달의 과금액
        pre = d-1-pre
    # 최대 과금 한도가 있어 한 달에 최대 다이아몬드 등급 기준액까지만 과금할 수 있다
    elif rank[i] == 'D':
        # 다이아몬드일 경우 sum 값은 그 등급 기준액이 최대임
        sum += d
        # 전 달의 과금액은 최댓값인 d
        pre = d
        
print(sum)