# 재귀함수를 이용한 백트래킹 방식
import sys
input = sys.stdin.readline
n, s = map(int, input().split())
data = list(map(int, input().split()))
count = 0

def subset_sum(i, sub_sum):
    global count
    if i >= n:
        return
    sub_sum += data[i]
    if sub_sum == s:
        count += 1
    
    # 현재 data[i]를 선택한 경우
    subset_sum(i+1, sub_sum)
    # 현재 data[i]를 선택하지 않은 경우
    subset_sum(i+1, sub_sum-data[i])

subset_sum(0, 0)
print(count)