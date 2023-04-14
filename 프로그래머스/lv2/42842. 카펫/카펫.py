def solution(brown, yellow):
    answer = []
    data = []
    # 노란색 격자의 수가 1이상이므로 카펫의 세로 길이는 3이상이어야 한다(즉, y값이 2이상)
    # 가로의 길이 : x, 세로의 길이 : y, y <= x
    for y in range(1, int(brown/2)):
        x = int(brown/2) - y
        data.append((x,y))
    for x, y in data:
        if (x+1)*(y+1) == brown+yellow:
            answer = [x+1, y+1]
            return answer