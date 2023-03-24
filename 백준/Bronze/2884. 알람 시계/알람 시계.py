H, M = map(int, input().split())
if (M-45) < 0:
    M += 15
    if H != 0:
        H -= 1
    else:
        H = 23
    print(H)
    print(M)
elif (M-45) >= 0:
    print(H)
    print(M-45)