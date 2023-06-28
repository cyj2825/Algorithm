def solution(number, limit, power):
    result = []
    # 각 기사단원의 정수 값에 대한 약수 개수 구하기
    for i in range(1, number+1):
        count = 0
        for j in range(1, int(i**(1/2)) + 1):
            if (i % j == 0):
                count += 1
                # j의 제곱값이 i가 아닐 경우 총 약수 2개를 더해준다
                if ( (j**2) != i) : 
                    count += 1
        if count > limit:
            count = power
        result.append(count)
    return sum(result)