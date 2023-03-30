def solution(nums):
    S = []
    answer = 0
    for i in nums:
        if i in S:
            continue
        else:
            S.append(i)
            answer += 1
    if answer > len(nums) * 0.5:
        answer = len(nums) * 0.5
    return answer