def solution(s):
    # 원래의 문자열 s의 길이가 가장 길 때
    answer = len(s)
    
    for i in range(1, len(s)//2 + 1):
        compressed = ""
        # 가장 맨 처음의 자른 문자열을 prev에 넣기
        prev = s[0:i]
        count = 1
        for j in range(i, len(s), i):
            # 만약 이전의 자른 문자열과 현재 자른 문자열이 같다면 count값 1 증가
            if prev == s[j:j+i]:
                count += 1
            else:
                # 만약 count값이 2이상이지만 더이상 이전 문자열과 같지 않다면 '2ab' 이런식으로 문자열 완성해서 넣기
                # 현재 자른 문자열과 이전 자른 문자열이 같지 않으므로 compressed에 prev 값을 붙인다
                if count >= 2:
                    compressed += str(count) + prev
                else:
                    compressed += prev
                # prev 값에 현재 자른 문자열을 넣는다
                prev = s[j:j+i]
                # count 값도 1로 초기화
                count = 1
        if count >= 2:
            compressed += str(count) + prev
        else:
            compressed += prev
        answer = min(answer, len(compressed))
    return answer