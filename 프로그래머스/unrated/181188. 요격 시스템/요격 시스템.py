def solution(targets):
    answer = 0
    # 좌표 e(x[1])를 기준으로 정렬
    targets.sort(key = lambda x: [x[1], x[0]])
    e = 0
    for target in targets:
        # 정렬된 미사일 좌표 s가 이전 미사일 e와 같거나 큰 경우는 같은 그룹으로 같이 요격할 수 없으므로 answer 값 증가
        if target[0] >= e:
            answer += 1
            e = target[1]
    return answer