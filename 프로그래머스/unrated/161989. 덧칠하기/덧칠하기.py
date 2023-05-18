def solution(n, m, section):
    # 칠하는 횟수
    answer = 1
    # 덧칠 시작값
    paint = section[0]
    
    for i in range(1, len(section)):
        # 만약 이전에 한 덧칠에 덧칠이 되지 않은 값이 존재한다면
        if section[i] - paint >= m:
            answer += 1
            paint = section[i]
    return answer