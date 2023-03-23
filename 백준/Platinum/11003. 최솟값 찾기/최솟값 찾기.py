# 다시보기
import sys
from collections import deque
input = sys.stdin.readline

N, L = map(int, input().split())
mydeque = deque()    # 데이터를 담을 덱 자료구조(시간복잡도를 줄이기 위해 사용)
data = list(map(int, input().split()))   # 주어진 숫자 데이터 리스트

for i in range(N):
    # 덱의 마지막 위치에서부터 현재 값보다 큰 값은 덱에서 삭제
    while mydeque and mydeque[-1][0] > data[i]:
        mydeque.pop()
    mydeque.append((data[i], i))    # 덱의 마지막 위치에 현재 값, 인덱스 값 넣기
    
    # 슬라이딩 윈도우 범위를 벗어난 데이터 삭제
    if mydeque[0][1] <= i-L:
        mydeque.popleft()   # 덱 앞에서 뺄 때는 popleft 해줘야 함
    print(mydeque[0][0], end = ' ')