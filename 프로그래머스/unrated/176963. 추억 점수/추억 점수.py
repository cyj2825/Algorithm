def solution(name, yearning, photo):
    answer = []
    dic = {}
    for i in range(len(name)):
        dic[name[i]] = yearning[i]
    for i in photo:
        value = 0
        for j in i:
            if j in name:
                value += dic[j]
        answer.append(value)
    return answer