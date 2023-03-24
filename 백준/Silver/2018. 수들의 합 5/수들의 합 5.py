# 다시보기
n = int(input())
start_index = 1
end_index = 1
count = 1    # n값 하나 있을 때의 경우의 수 미리 추가
sum = 1

while end_index != n:
    if sum == n:
        count += 1
        end_index += 1
        sum += end_index
    elif sum > n:
        sum -= start_index
        start_index += 1
    else:
        end_index += 1
        sum += end_index
print(count)