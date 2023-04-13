import sys
input = sys.stdin.readline
n = int(input())
data = []

for _ in range(n):
    age, name = map(str, input().split())
    data.append((int(age), name))
# 리스트를 sort할 때 key = lambda x : x[0]을 써주지 않는다면 알파벳순으로 이름을 정렬해준다
data.sort(key = lambda x : x[0])

for i in range(n):
    print(data[i][0], data[i][1])