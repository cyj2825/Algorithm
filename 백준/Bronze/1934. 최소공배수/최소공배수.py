n = int(input())

# 최대 공약수 gcd() 함수 구현
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)    # 재귀 형태로 구현
    
for i in range(n):
    a, b = map(int, input().split())
    result = a * b / gcd(a, b)
    print(int(result))