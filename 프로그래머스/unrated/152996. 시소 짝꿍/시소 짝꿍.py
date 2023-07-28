from collections import Counter

def solution(weights):
    answer = 0
    count_weights = Counter(weights)
    
    # 개수가 2개 이상일 경우 n개의 원소 중에서 무작위로 2개를 뽑는 경우의 수이므로 nC2 = n * (n-1)
    for k, v in count_weights.items():
        if(v > 1):
            answer += v * (v - 1) // 2
    # 앞에 코드로 인해 중복값에 대한 연산이 필요없어짐        
    set_weights = set(weights)
    # 2:3, 2:4, 3:4 비율을 가진다면 짝꿍이 될 수 있음
    for w in set_weights:
        # 이때 counter한 값으로 곱해서 구해야 여러 개 존재하는 숫자에 대한 경우의 수도 고려할 수 있음
        if w * 2/3 in set_weights:
            answer+= count_weights[w * 2/3] * count_weights[w]
        if w * 2/4 in set_weights:
            answer+= count_weights[w * 2/4] * count_weights[w]
        if w * 3/4 in set_weights:
            answer+= count_weights[w * 3/4] * count_weights[w]
                
    return answer