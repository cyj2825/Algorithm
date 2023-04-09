def solution(n, lost, reserve):
    # set은 공통 요소를 제거해주는 집합
    # lost와 reserve 리스트 각각 서로 같은 값이 있다면 제거해주고 시작
    set_reserve = set(reserve)-set(lost)
    set_lost = set(lost)-set(reserve)

    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
            
    return n-len(set_lost)