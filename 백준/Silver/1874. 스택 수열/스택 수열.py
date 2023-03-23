n = int(input())
s = []
answer = []
result = 1
num = 1

for i in range(n):
    a = int(input())
    while a >= num:
        s.append(num)
        answer.append("+")
        num += 1
    if s[-1] == a:
        s.pop()
        answer.append("-")
    else:
        print("NO")
        result = 0
        break
if result == 1:
    for i in answer:
        print(i)