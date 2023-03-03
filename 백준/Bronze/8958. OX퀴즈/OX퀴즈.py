n = int(input())
datas = [input() for _ in range(n)]

for data in datas:
    num = 0
    a = 0
    for i in range(len(data)):
        if data[i] == 'O':
            a += 1
            num += a
        elif data[i] == 'X':
            a = 0
    print(num)