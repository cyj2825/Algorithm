def solution(n, arr1, arr2):
    answer = []
    list1 = []
    list2 = []
    for i in arr1:
        val1 = format(i, 'b')    # 10진수를 2진수로 변환
        if len(val1) != n:
            val1 = "0"*(n-len(val1)) + val1
        list1.append(val1)
        
    for i in arr2:
        val2 = format(i, 'b')    # 10진수를 2진수로 변환
        if len(val2) != n:
            val2 = "0" * (n-len(val2)) + val2
        list2.append(val2)
        
    for i in range(n):
        ans = ""
        for j in range(n):
            if (int(list1[i][j]) == 1) or (int(list2[i][j]) == 1):
                ans += "#"
            else:
                ans += " "
        answer.append(ans)
    return answer