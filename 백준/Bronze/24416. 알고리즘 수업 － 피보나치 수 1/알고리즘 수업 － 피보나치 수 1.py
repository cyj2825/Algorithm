n = int(input())
count1, count2 = 0, 0
f = [0] * (n+1)

# 피보나치 수 재귀호출 함수
def fib(n):
    global count1
    if n == 1 or n == 2:
        count1 += 1
        return 1
    else:
        return fib(n - 1) + fib(n - 2)

# 피보나치 수 동적 프로그래밍 함수
def fibonacci(n):
    global count2
    f[1] = 1
    f[2] = 1
    for i in range(3, n+1):
        count2 += 1
        f[i] = f[i-1] + f[i-2]
    return f[n]

fib(n)
fibonacci(n)
print(count1, count2)