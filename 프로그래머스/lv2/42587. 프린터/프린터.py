from collections import deque

def solution(priorities, location):
    # 인덱스와 그 인덱스에 해당하는 원소값을 모두 출력해주는 enumerate함수를 이용하여 location 값을 바로 찾을 수 있도록 함
    q = deque([(v, i) for i, v in enumerate(priorities)])
    answer = 0
    
    while q:  # q가 빌 때까지
        data = q.popleft()             # q의 원소를 나눠서 받지 말고 한 번에 받아서 인덱스값으로 구분해서 사
        # q가 비었는지 확인 필요!
        if q and data[0] < max(q)[0]:   # max함수 사용 시 튜플로 구성되어 있는 것은 max()[] 뒤에 최대값을 찾을 인덱스를 넣어주자
            q.append(data)
        else:
            answer += 1
            if data[1] == location:
                break
    return answer
        