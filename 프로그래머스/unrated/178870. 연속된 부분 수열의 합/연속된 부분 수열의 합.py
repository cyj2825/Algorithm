def solution(sequence, k):
    answer = []
    left, right = 0, -1
    data = 0
    while True:
        if data < k:
            right += 1
            if right >= len(sequence):
                break
            data += sequence[right]
        else:
            data -= sequence[left]
            if left >= len(sequence):
                break
            left += 1
        if data == k:
            answer.append([left, right])
    # (right-left)가 가장 작은 수열부터 정렬
    answer.sort(key=lambda x: (x[1] - x[0], x[0]))
    return answer[0]