def solution(s):
    answer = []
    for i in range(len(s)):
        if i == 0:
            answer.append(-1)
        else:
            if s[i] not in s[:i]:
                answer.append(-1)
            else:
                # s[i]값이 여러 개 존재할 경우를 위해 해당하는 모든 index값 받기
                a = list(filter(lambda x: s[x] == s[i], range(i)))
                answer.append(i-max(a))
    return answer