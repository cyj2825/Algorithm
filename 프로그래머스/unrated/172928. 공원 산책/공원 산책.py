def solution(park, routes):
    answer = []
    d = {'N': [-1, 0], 'S': [1, 0], 'W': [0, -1], 'E': [0, 1]}
    isPossible = True
    H = len(park)
    W = len(park[0])
    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                x, y = i, j
                answer.append(i)
                answer.append(j)
    for i in routes:
        op = i[0]
        n = int(i[-1])
        nx = x + d[op][0] * n
        ny = y + d[op][1] * n
        if 0 > nx or nx >= H or 0 > ny or ny >= W:
            continue
        a, b = x, y
        for _ in range(n):
            a += d[op][0]
            b += d[op][1]
            if park[a][b] == 'X':
                isPossible = False
                break
        if not isPossible:
            isPossible = True
            continue
        x, y = nx, ny
        answer[0] = x
        answer[1] = y
    return answer