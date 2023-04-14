def solution(answers):
    answer = []
    num1 = 0
    num2 = 0
    num3 = 0
    # 수포자 1의 정답 방식을 dictionary로 표현
    dic1 = {0:1, 1:2, 2:3, 3:4, 4:5}
    # 수포자 2의 정답 방식을 dictionary로 표현
    dic2 = {0:2, 1:1, 2:2, 3:3, 4:2, 5:4, 6:2, 7:5}
    # 수포자 3의 정답 방식을 dictionary로 표현
    dic3 = {0:3, 1:3, 2:1, 3:1, 4:2, 5:2, 6:4, 7:4, 8:5, 9:5}
    
    for i in range(len(answers)):
        if answers[i] == dic1[i%5]:
            num1 += 1
        if answers[i] == dic2[i%8]:
            num2 += 1
        if answers[i] == dic3[i%10]:
            num3 += 1
    
    x = [num1, num2, num3]
    # 인덱스와 원소값을 출력하는 enumerate 함수를 통해 x안에 최댓값이 여러 개라도 모두 출력할 수 있도록 함
    for i, v in enumerate(x):
        if v == max(x):
            answer.append(i+1)
    return answer