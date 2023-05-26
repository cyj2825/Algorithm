def solution(name):
    # 조이스틱 조작 횟수
    answer = 0
    # 기본 좌우 이동 횟수
    move = len(name) - 1
    for i, c in enumerate(name):
        # 해당 알파벳 변경 최솟값 answer에 더하기
        # 뒤쪽에서 세는 경우 +1 해준 이유는 Z로 넘어갈 때에 해당하는 1번을 더해줘야 하므로
        answer += min(ord(c) - ord('A'), ord('Z') - ord(c) + 1)
        
        # 해당 알파벳 다음부터 연속된 'A' 문자열 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
        # 기존값, 연속된 A의 왼쪽 시작 경우, 연속된 A의 오른쪽 시작 경우 비교
        # 연속 A의 무리를 왼쪽 시작하는 경우는 해당 무리의 왼쪽 부분을 두 번 지나가기 때문에 2 * i + (len(name) - next) (오른쪽 부분에 해당하는 값)
        # 연속 A의 무리를 오른쪽 시작하는 경우는 해당 무리의 오른쪽 부분을 두 번 지나가기 때문에 2*(len(name)-next) + i(왼쪽 부분에 해당하는 값)
        move = min(move, 2 * i + len(name) - next, i + 2 * (len(name) - next))
    answer += move
    return answer