T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    answer = 0
    max_y = n
    for x in range(1, n+1):
        for y in range(max_y, -1, -1):
            if x**2 + y**2 <= n**2:
                # x가 작을 때의 y의 최대값보다 큰 값을 가질 수 없기 때문
                max_y = y
                # y값이 0일 때 잊지 않고 추가하기
                answer += y + 1
                break
    answer = answer * 4 + 1
    print(f'#{test_case} {answer}')
