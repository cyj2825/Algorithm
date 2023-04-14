def solution(phone_book):
    answer = True
    # sort 함수로 정렬해주면 어떤 번호가 다른 번호의 접두어라면 이 둘은 앞뒤에 위치하게 된다
    phone_book.sort()
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) <= len(phone_book[i+1]):
            if phone_book[i+1][:len(phone_book[i])] == phone_book[i]:
                answer = False
                break
    return answer