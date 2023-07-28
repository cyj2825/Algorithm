import heapq
def solution(jobs):
    answer, start, now, i = 0, -1, 0, 0
    q = []
    # i가 jobs의 길이보다 작을 경우 반복
    while i < len(jobs):
        # 현재 시점에서 처리할 수 있는 작업인지를 판별하는 조건은 작업의 요청 시간이 바로 이전에 완료한 작업의 시작 시간(start)보다 크고 현재 시점(now)보다 작거나 같아야 함
        for j in jobs:
            if start < j[0] <= now:
                heapq.heappush(q, [j[1], j[0]])
        if len(q) > 0:
            present = heapq.heappop(q)
            # start값을 현재 시점으로 갱신
            start = now
            # 현재 시점의 경우는 현재 작업의 소요 시간을 더해줘야 함
            now += present[0]
            answer += (now - present[1])
            i += 1
        else:
            now += 1
    return int(answer / len(jobs))