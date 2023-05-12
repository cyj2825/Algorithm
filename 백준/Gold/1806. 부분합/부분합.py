import sys
input = sys.stdin.readline
n, s = map(int, input().split())
data = list(map(int, input().split()))
start, end = 0, 0
value = 0
min_length = 1e9

while True:
    if value >= s:
        min_length = min(min_length, end - start)
        value -= data[start]
        start += 1
    elif end == n:
        break
    else:
        # end 값이 0부터 시작했으므로 가장 맨 앞의 값을 더해주기 위해 value += data[end]가 먼저 나오고 end += 1해줘야 함
        value += data[end]
        end += 1

if min_length == 1e9:
    print(0)
else:
    print(min_length)