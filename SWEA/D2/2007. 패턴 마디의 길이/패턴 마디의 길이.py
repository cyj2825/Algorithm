T = int(input())
for test_case in range(1, T + 1):
    data = input()
    for i in range(1, 11):
        if data[:i] == data[i:2*i]:
            answer = i
            break
        
    print(f'#{test_case} {answer}')