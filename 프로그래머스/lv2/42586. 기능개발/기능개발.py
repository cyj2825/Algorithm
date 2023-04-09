# Queue를 이용한 문제 풀이
def solution(progresses, speeds):
    answer = []
    
    # progresses가 빌 때까지 계속 반복
    while progresses:
        # 하루에 배포될 기능 수
        count = 0
        
        # progresses가 남아있고 맨 앞의 작업의 진도가 100이상인 경우
        while progresses and progresses[0] >= 100:
            count += 1
            # pop(0)은 첫번째 데이터를 꺼내는 것(제거)
            progresses.pop(0)
            speeds.pop(0)
        
        # 시간이 흘러 변한 작업의 진도값을 progresses에 업데이트
        progresses = [progresses[i]+speeds[i] for i in range(len(progresses))]
        
        # count 값이 0이 아니면 그날 기능이 배포된 것으로 answer 리스트에 추가
        if count:
            answer.append(count)
    return answer