def solution(storey):
    answer = 0
    while storey:
        first = storey % 10
        # 6부터 9일 경우
        if first > 5:
            answer += 10 - first
            # 바로 위 자릿수 값을 1 추가해야 함
            storey += 10
        # 0부터 4일 경우
        elif first < 5:
            answer += first
        # 5일 경우
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += first
        storey //= 10
    return answer