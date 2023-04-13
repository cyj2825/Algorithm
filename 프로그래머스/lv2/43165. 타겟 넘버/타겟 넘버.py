def solution(numbers, target):
    n = len(numbers)
    answer = 0
    def DFS(idx, result):
        if idx == n:
            if result == target:
                # 비지역 변수값 answer을 갱신하기 위해 nonlocal 사용
                nonlocal answer
                answer += 1
            return
        else:
            # 한 숫자당 +,- 두 가지 가능하므로 DFS 두 번 호출(재귀함수)
            DFS(idx+1, result+numbers[idx])
            DFS(idx+1, result-numbers[idx])
    DFS(0,0)
    return answer