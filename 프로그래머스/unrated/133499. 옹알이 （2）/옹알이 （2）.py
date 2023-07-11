def solution(babbling):
    answer = 0
    # 가능한 발음 리스트 저장
    words = ["aya", "ye", "woo", "ma"]
    
    for i in babbling:
        for j in words:
            # 연속해서 같은 발음을 할 경우는 제외
            if j * 2 not in i:
                # 조카가 가능한 발음은 모두 공백으로 바꾸어 줌
                i = i.replace(j, ' ')
        # 모든 가능한 단어를 스캔한 단어가 공백이라면 answer 1 추가
        if i.strip() == '':
            answer += 1
    return answer