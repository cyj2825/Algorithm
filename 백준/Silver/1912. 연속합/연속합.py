n = int(input())
data = list(map(int, input().split()))
# sum의 0번째 인덱스에는 비교를 위해 data[0]값을 넣어준다
sum = [data[0]]

for i in range(len(data) - 1):
    # sum의 i번째 인덱스의 값 + data의 i+1번째 인덱스의 값과 data의 i+1번째 인덱스의 값 비교
    sum.append(max(sum[i] + data[i + 1], data[i + 1]))
print(max(sum))