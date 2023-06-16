def solution(s, skip, index):
    answer = ''
    # 알파벳 전체를 저장
    data = "abcdefghijklmnopqrstuvwxyz"
    
    for i in skip:
        if i in data:
            # data 안에 skip 문자들을 없애기
            data = data.replace(i, "")
    
    for i in s:
        # data에 i의 index값 + index
        # z값을 넘어가는 경우를 고려하기 위해 data의 길이로 나눈 나머지 값 출력
        answer += data[(data.index(i) + index) % len(data)]
    return answer