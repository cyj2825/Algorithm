# 백준 1181번 단어 정렬
import sys
input = sys.stdin.readline
n = int(input())
data = []

for i in range(n):
    data.append(input().strip())    # 문자열의 시작 또는 끝에 있는 문자를 제거하여 문자열 있는 그대로 반환
    
set_data = set(data)
data = list(set_data)
data.sort()
data.sort(key = len)

for i in data:
    print(i)