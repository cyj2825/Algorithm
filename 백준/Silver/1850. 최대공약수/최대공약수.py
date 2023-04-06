# 최대 공약수 함수 
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a%b)
    
a, b = map(int, input().split())
result = gcd(a, b)

while result > 0:     # result값만큼 반복하여 1 출력
    print(1, end='')
    result -= 1