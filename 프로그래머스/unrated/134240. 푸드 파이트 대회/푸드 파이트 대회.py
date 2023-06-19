def solution(food):
    answer = ''
    for i in range(1, len(food)):
        if food[i] // 2 != 0:
            answer += food[i] // 2 * str(i)
    answer += '0'
    for j in reversed(range(1, len(food))):
        if food[j] // 2 != 0:
            answer += food[j] // 2 * str(j)
    return answer