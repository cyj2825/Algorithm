n = list(map(int, input()))
left = n[0:len(n)//2]
right = n[len(n)//2:]
if sum(left) == sum(right):
    print("LUCKY")
else:
    print("READY")