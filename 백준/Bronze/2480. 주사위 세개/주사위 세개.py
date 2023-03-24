A = list(map(int, input().split()))
A.sort()
price = 0

if A[0] == A[2]:
    price = 10000+A[0]*1000
    print(price)
elif A[0] == A[1] or A[1] == A[2]:
    price = 1000+A[1]*100
    print(price)
else:
    price = A[2]*100
    print(price)