def solution(keymap, targets):
    answer = []
    for word in targets:
        # 누른 키 총합
        sol = 0
        for i in word:
            isPossible = False
            # keymap의 원소의 길이가 최대 100
            a = 101
            for j in keymap:
                # keymap의 문자열에 i(구해야 하는 문자)가 존재하면
                if i in j:
                    a = min(a, j.index(i)+1)
                    isPossible = True
            if not isPossible:
                sol = -1
                break
            sol += a
        answer.append(sol)
    return answer