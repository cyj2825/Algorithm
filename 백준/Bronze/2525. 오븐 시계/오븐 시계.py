A, B = map(int, input().split())
C = int(input())
if (B+C) < 60:
    print(A)
    print(B+C)
elif (B+C) > 60:
    A += (B+C)//60
    if (B+C)%60 == 0:
        if A > 23:
            print(A-24)
            print("0")
        else:
            print(A)
            print("0")
    else:
        B = (B+C)%60
        if A > 23:
            print(A-24)
            print(B)
        else:
            print(A)
            print(B)
else:
    if (A+1) != 24:
        print(n+1)
        print("0")
    else:
        print("0")
        print("0")