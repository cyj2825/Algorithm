def solution(citations):
    # citations는 발표한 논문의 인용 횟수를 담은 배열
    citations.sort()
    l = len(citations)
    
    for i in range(l):
        # citations에서 존재하는 값만 h가 될 수 있는 것이 아님
        if citations[i] >= l-i:
            return l-i
    return 0