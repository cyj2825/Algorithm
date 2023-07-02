from collections import deque

def solution(x, y, n):
    q = deque()
    # q에는 현재 값인 x와 지금까지 진행한 연산 횟수를 넣어준다
    q.append((x, 0))
    # 중복값 저장을 방지하기 위해 set() 함수 사용
    visited = set()
    
    while q:
        a, b = q.popleft()
        # 만약 a값이 y보다 크거나 이미 계산된 적이 있는 값일 경우 다시 popleft 진행
        if a > y or a in visited:
            continue
        visited.add(a)
        # 만약 a값이 y값이 되었을 경우 지금까지 진행한 연산 횟수 값이 j를 return
        if a == y:
            return b
        for i in (a * 3, a * 2, a + n):
            if i <= y and i not in visited:
                q.append((i, b + 1))
    return -1