fatigue=[[1,1,1],[5,1,1],[25,5,1]]
answer = 1e9
dic = {"diamond": 0, "iron": 1, "stone": 2}
 
# DFS 함수 구현
def DFS(idx, d, ir, s, minerals, f):
    # 종료 조건
    # 모든 광물을 캤거나 남은 도구가 없을때
    if idx >= len(minerals) or (not d and not ir and not s):
        global answer
        # 현재까지 구한 값과 최솟값을 비교하여 갱신
        answer = min(answer, f)
        return
    dfa, ifa, sfa = 0, 0, 0
    # 5개의 광물에 대해 더하기
    for i in range(idx, min(idx+5, len(minerals))):
        dfa += fatigue[0][dic[minerals[i]]]
        ifa += fatigue[1][dic[minerals[i]]]
        sfa += fatigue[2][dic[minerals[i]]]
    # 다이아몬드를 캐는 경우
    if d:
        DFS(idx+5, d-1, ir, s, minerals, f+dfa)
    # 철을 캐는 경우
    if ir:
        DFS(idx+5, d, ir-1, s, minerals, f+ifa)
    # 돌을 캐는 경우
    if s:
        DFS(idx+5, d, ir, s-1, minerals, f+sfa)

def solution(picks, minerals):
    global answer
    # DFS 시작
    DFS(0, picks[0], picks[1], picks[2], minerals, 0)
    return answer