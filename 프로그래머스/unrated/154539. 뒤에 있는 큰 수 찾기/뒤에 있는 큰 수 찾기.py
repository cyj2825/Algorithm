def solution(numbers):
    # answer를 배열 numbers 크기만큼 -1로 초기화
    answer = [-1] * len(numbers)
    # 뒷 큰수를 찾지 못한 인덱스값을 s 스택에 넣어둔다
    s = []
    
    # 배열 numbers 한바퀴 돌기
    for i in range(len(numbers)):
        # s 스택 안에 값이 존재하고 s 마지막 인덱스의 value와 numbers[i]값을 비교하여 numbers[i]가 클 경우
        while s and numbers[s[-1]] < numbers[i]:
            # s의 마지막 인덱스 값을 꺼내고 answer 해당 위치에 뒷 큰수 값인 numbers[i]를 넣어준다
            answer[s.pop()] = numbers[i]
        s.append(i)
        
    return answer