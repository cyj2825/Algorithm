# 다시보기
from queue import PriorityQueue
import sys
input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
myQueue = PriorityQueue()
for i in range(n):
    data = int(input())
    if data == 0:
        if myQueue.empty():
            print('0\n')
        else:
            print(str(myQueue.get()[1])+'\n')  # PriorityQueue는 (우선순위, 값)으로 구성되어있음
    else:
        # 절댓값을 기준으로 정렬하고 같으면 음수 우선 정렬하도록 구성
        myQueue.put((abs(data), data))