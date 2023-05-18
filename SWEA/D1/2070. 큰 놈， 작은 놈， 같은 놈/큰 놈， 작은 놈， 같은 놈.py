T = int(input())
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    answer = ''
    if a < b:
        answer = '<'
    elif a > b:
        answer = '>'
    else:
        answer = '='
    print("#{} {}".format(test_case, answer))
