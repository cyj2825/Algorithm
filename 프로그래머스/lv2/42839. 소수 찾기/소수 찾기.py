from itertools import permutations
def solution(numbers):
    answer = []
    num = [n for n in numbers]
    per = []
    # numbers의 각 숫자들을 순열로 모든 경우 만들기
    for i in range(1, len(numbers)+1):
        # numbers 값 중 i개 선택한 조합을 per 리스트에 넣기
        per += list(permutations(num, i))
    # 각 순열조합을 하나의 int형 숫자로 변환
    new_num = [int("".join(p)) for p in per]
    for n in new_num:
        if n < 2:
            continue
        check = True
        # n의 제곱근보다 작은 숫자까지만 나눗셈
        for i in range(2, int(n**0.5)+1):
            if n % i == 0:
                # 하나라도 나누어떨어진다면 소수가 아니므로 check 값 False로 변경
                check = False
                break
        if check:
            answer.append(n)
    # set 함수를 통해 중복 제거
    return len(set(answer))