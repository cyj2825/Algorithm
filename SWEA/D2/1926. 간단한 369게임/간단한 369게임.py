n = int(input())
for i in range(1, n+1):
    count = 0
    for j in str(i):
        if str(j) in ('3', '6', '9'):
            count += 1
    if count > 0:
        print('-' * count, end=' ')
    else:
        print(i, end = ' ')
