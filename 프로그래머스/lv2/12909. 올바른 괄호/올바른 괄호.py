def solution(s):
    count = 0
    
    for i in s:
        if i == '(':
            count += 1
        elif i == ')':
            count -= 1
        if count < 0:
            return False
    
    if count == 0:
        return True
    elif count > 0:
        return False