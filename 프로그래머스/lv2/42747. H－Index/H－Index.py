def solution(citations):
    # citations는 발표한 논문의 인용 횟수를 담은 배열
    citations.sort()
    l = len(citations)
    
    for i in range(l):
        if citations[i] >= l-i:
            return l-i
    return 0