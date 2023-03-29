from collections import deque
n = int(input())
dataQueue = deque()

for i in range(1, n+1):
    dataQueue.append(i)

while len(dataQueue) > 1:
    dataQueue.popleft()                    # 맨 위의 카드 1장 버림
    dataQueue.append(dataQueue.popleft())  # 맨 위의 카드 1장을 가장 아래 카드 밑으로 이동
print(dataQueue[0])