from collections import Counter

def solution(topping):
    answer = 0
    # 우선 철수에게 롤케이크를 다 주고
    c = Counter(topping)
    # 동생에게 하나씩 넘겨주는 방법으로 구현
    d = Counter()
    
    for i in range(len(topping)):
        # 현재 토핑 종류를 동생이 이미 갖고 있을 경우 해당 값 + 1 해주기
        if topping[i] in d:
            d[topping[i]] += 1
        # 갖고 있지 않을 경우 값을 1로 넣어준다
        else:
            d[topping[i]] = 1
        c[topping[i]] -= 1
        if c[topping[i]] == 0:
            del c[topping[i]]
        if (len(c) == len(d)):
            answer += 1
        
    return answer