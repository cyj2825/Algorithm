# 다시보기
# hash 사용 (Key-Value)
def solution(participant, completion):
    hashDict = {}
    sumHash = 0
    
    for part in participant:
        # Hash : Participant의 dictionary 만들기
        hashDict[hash(part)] = part
        # Participant의 sum(hash) 구하기, hash(part)값은 각 value에 지정된 key 값
        sumHash += hash(part)
    
    # completion의 sum(hash) 빼기
    for comp in completion:
        sumHash -= hash(comp)
    
    # 남은 값이 완주하지 못한 선수의 hash 값이 된다
    return hashDict[sumHash]