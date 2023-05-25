# 문자열 값을 int값으로 변경하는 함수
def change_to_int(time):
    # playtime일 경우 int값으로만 변경하여 return
    if ':' not in time:
        return int(time)
    # start일 경우 시와 분으로 나누어 int 값으로 return
    h, m = time.split(':')
    return int(h) * 60 + int(m)

def solution(plans):
    answer = []
    left =[]
    p = []
    for name, start, playtime in plans:
        p.append((name, change_to_int(start), change_to_int(playtime)))
    # start 값을 기준으로 오름차순 정렬
    p.sort(key = lambda x:x[1])
    
    for i in range(len(p)):
        # 마지막 과제일 경우
        if i == len(p) - 1:
            answer.append(p[i][0])
            # 아직 끝내지 않은 과제 name들이 들어있는 left 리스트를 뒤에서부터 차례차례 넣기
            for j in range(-1, -len(left)-1, -1):
                answer.append(left[j][0])
            break
        # 다음 과제 시작 시간 - (현재 과제 시작 시간 + 과제 진행 시간)
        extra = p[i+1][1] - (p[i][1] + p[i][2])
        # extra 값이 양수일 경우 시간 안에 해당 과제를 끝낼 수 있고 이전에 해결하지 못한 과제도 진행가능
        if extra >= 0:
            answer.append(p[i][0])
            while left:
                # extra 값이 left의 맨 뒤의 값의 남은 시간보다 클 경우
                if left[-1][1] <= extra:
                    x = left.pop()
                    extra -= x[1]
                    answer.append(x[0])
                # extra 값이 left의 맨 뒤의 값의 남은 시간보다 작을 경우
                else:
                    # extra 값만큼만 빼줌
                    left[-1][1] -= extra
                    break
        # 다음 과제 시작 시간까지 못 끝낸 경우 left 리스트에 넣는다
        else:
            left.append([p[i][0], -extra])
    
    return answer