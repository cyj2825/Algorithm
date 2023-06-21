import sys
input = sys.stdin.readline
n = int(input())
# n개의 값을 갖고 있는 수열 받기
data = list(map(int, input().split()))
# 각 인덱스 위치에 가장 큰 증가 부분 수열의 합을 구하기 위한 리스트
d = [0] * n
# 초기값 세팅
d[0] = data[0]

# 반복문을 통해 각 인덱스 위치에 가장 큰 증가 부분 수열의 합 구하기
for i in range(1, n):
    # 현재 인덱스 값과 이전 인덱스 값들을 비교
    for j in range(i):
        # 현재 수가 이전 인덱스 값보다 크면
        # 현재 인덱스 위치에 가장 큰 부분 수열의 합과 이전 인덱스 위치에 가장 큰 부분 수열의 합 + 현재 수 값을 비교하여 더 큰 값을 d에 넣는다
        if data[j] < data[i]:
            d[i] = max(d[i], d[j] + data[i])
        # 현재 수보다 이전 인덱스 값이 더 크다면 현재 인덱스 위치에 가장 큰 부분 수열의 합과 현재 수를 비교하여 더 큰 값을 d에 넣는다
        else:
            d[i] = max(d[i], data[i])
print(max(d))