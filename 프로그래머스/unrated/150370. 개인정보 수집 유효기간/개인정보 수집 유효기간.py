def solution(today, terms, privacies):
    answer = []
    d = {}
    # '.'을 기준으로 today year, month, day값을 저장
    today_y, today_m, today_d = map(int, today.split('.'))
    
    # 약관의 유효기간을 담은 terms 값을 d에 저장 
    for i in terms:
        value, month = i.split()
        d[value] = int(month)
        
    for i, value in enumerate(privacies):
        date, x = value.split()
        y, m, day = map(int, date.split('.'))
        m += d[x]
        # 개인정보 수집 일자 + 유효기간(달)을 더했을 때 12보다 크면 년을 증가시키고 줄이는 작업 필요
        while m > 12:
            m -= 12
            y += 1
        # 맨 마지막에 파기해야 할 조건에 모두 부합하는 순서값만 answer에 넣기 위해 check
        if y > today_y:
            continue
        elif y == today_y:
            if m > today_m:
                continue
            elif m == today_m:
                if day > today_d:
                    continue
        answer.append(i+1)
    return answer