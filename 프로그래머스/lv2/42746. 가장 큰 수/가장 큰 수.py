def solution(numbers):
    # int형의 list를 map을 사용하여 string으로 치환한 뒤 list로 변환
    answer = list(map(str, numbers))
    # number의 원소는 1000이하의 숫자이므로 3번 반복한 값으로 sort
    # 6, 10, 2 => 666, 101010, 222
    answer.sort(key=lambda x: x*3, reverse = True)
    return str(int(''.join(answer)))