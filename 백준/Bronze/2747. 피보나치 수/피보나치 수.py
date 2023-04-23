# 톱-다운 구현 방식으로 코드 작성
import sys
input = sys.stdin.readline
n = int(input())
# DP 리스트 초기화
D = [-1] * (n+1)
# 가장 작은 문제 -> 이미 아는 값
D[0] = 0
D[1] = 1 

def fibo(n):
	# 기존에 계산한 적이 있는 부분의 문제는 재계산하지 않고 리턴
	if D[n] != -1:
		return D[n]
	# 메모이제이션 : 구한 값을 바로 리턴하지 않고 DP 테이블에 저장한 후 리턴하도록 로직 구현
	D[n] = fibo(n-2) + fibo(n-1)
	return D[n]

fibo(n)
print(D[n])