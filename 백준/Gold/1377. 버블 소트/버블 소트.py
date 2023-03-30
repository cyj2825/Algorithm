# 다시보기
# 데이터의 정렬 전 index와 정렬 후 index를 비교해 왼쪽으로 많이 이동한 값 찾기
import sys
input = sys.stdin.readline
n = int(input())
A = []

for i in range(n):
    A.append((int(input()), i))    # 정렬 기준을 고려하여 데이터, index 순서로 저장
    
MAX = 0
# A를 오름차순으로 정렬
sorted_A = sorted(A)

for i in range(n):
    # 정렬 전 index - 정렬 후 index 최댓값 MAX에 저장
    if MAX < sorted_A[i][1] - i:
        MAX = sorted_A[i][1] - i

print(MAX+1)     # swap이 일어나지 않는 반복문이 한 번 더 실행되기 때문에 +1