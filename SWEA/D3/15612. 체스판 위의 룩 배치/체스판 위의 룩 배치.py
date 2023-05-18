T = int(input())
def count():
    row = [0, 0, 0, 0, 0, 0, 0, 0]
    col = [0, 0, 0, 0, 0, 0, 0, 0]
    count = 0
    for i in range(8):
        for j in range(8):
            if data[i][j] == 'O':
                row[i] += 1
                col[j] += 1
                count += 1
                if row[i] >= 2 or col[j] >= 2:
                    return False
    if count == 8:
        return True
    else:
        return False
for test_case in range(1, T + 1):
    data = [list(input().strip()) for _ in range(8)]
    if count():
        print(f'#{test_case} yes')
    else:
        print(f'#{test_case} no')