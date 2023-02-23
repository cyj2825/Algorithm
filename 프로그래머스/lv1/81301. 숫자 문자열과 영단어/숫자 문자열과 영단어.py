def solution(s):
    data = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    answer = ''
    # 인덱스와 그 값을 동시에 접근하기 위한 enumerate()
    for idx, num in enumerate(data):
        if num in s:
            s = s.replace(num, str(idx))
        answer = s
    return int(answer)