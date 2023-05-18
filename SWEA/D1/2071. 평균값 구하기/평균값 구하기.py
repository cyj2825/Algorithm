T = int(input())
anwer = 0
for test_case in range(1, T + 1):
    data = list(map(int, input().split()))
    answer = round(sum(data) / 10)
    print("#{} {}".format(test_case, answer))