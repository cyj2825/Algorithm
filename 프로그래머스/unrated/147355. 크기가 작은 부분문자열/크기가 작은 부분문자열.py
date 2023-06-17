def solution(t, p):
    answer = 0
    pl = len(p)
    tl = len(t)
    data = ""
    for i in range(0, tl-pl+1):
        data = t[i:i+pl]
        if int(data) <= int(p):
            answer += 1
    return answer