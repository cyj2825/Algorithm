import math

def solution(r1, r2):
    answer = 0
    for i in range(1, r2 + 1):
        # 뒤에 +1을 한 이유는 r1 원의 둘레에 찍힌 점을 더해줘야 하기 때문
        # max 값을 사용한 이유는 i값이 r1보다 클 경우 음수이므로 자동으로 0으로 값을 주기 위해서
        answer += math.floor((r2 ** 2 - i ** 2) ** 0.5) - math.ceil(max(0, r1 ** 2 - i ** 2) ** 0.5) + 1
    return answer * 4