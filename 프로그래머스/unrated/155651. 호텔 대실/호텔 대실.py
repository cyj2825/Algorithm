import heapq
def solution(book_time):
    # 맨 처음 한 개의 객실은 무조건 가지고 있기 때문에 1로 초기화
    answer = 1
    
    # 시작 시간, 종료 시간 모두 분단위의 숫자형으로 변경, "HH:MM" → HH * 60 + MM
    room = [(int(s[:2]) * 60 + int(s[3:]), int(e[:2]) * 60 + int(e[3:])) for s, e in book_time]
    room.sort()
    
    q = []
    for s, e in room:
        # q가 비어있을 경우 종료 시각을 push
        if not q:
            heapq.heappush(q, e)
            continue
        # q값이 다음 시작 시간보다 작거나 같을 경우 pop
        if q[0] <= s:
            heapq.heappop(q)
        # q값이 다음 시작 시간보다 클 경우 새로운 객실 생성
        else:
            answer += 1
        heapq.heappush(q, e + 10)
    return answer