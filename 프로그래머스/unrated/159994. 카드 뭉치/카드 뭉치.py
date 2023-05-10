def solution(cards1, cards2, goal):
    answer = "Yes"
    for i in goal:
        if len(cards1) != 0:
            if i == cards1[0]:
                cards1.remove(cards1[0])
                continue
        if len(cards2) != 0:
            if i == cards2[0]:
                cards2.remove(cards2[0])
                continue
        answer = "No"
    return answer