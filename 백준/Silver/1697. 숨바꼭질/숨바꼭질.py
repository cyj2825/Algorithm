from collections import deque
# n: 수빈이의 현재 점, k: 동생의 점
n, k = map(int, input().split())
MAX = 10 ** 5
# data의 인덱스값에 해당하는 노드까지 가는데 걸린 시간을 축적하기 위한 리스트
data = [0] * (MAX + 1)

def BFS(v):
    q = deque()
    q.append(v)
    # q가 빌 때까지 반복
    while q:
        x = q.popleft()
        if x == k:
            return data[x]
        # 기존 위치에서 이동할 수 있는 위치는 총 3가지 => 가능한 방법이 몇 개 나올 경우 이 방법 이용하자!
        for i in (x-1, x+1, x*2):
            # i값이 0부터 MAX값 사이에 존재해야 하고 아직 가지 않은 즉 data 리스트가 0값이어야 이동 가능
            if 0 <= i <= MAX and not data[i]:
                # 최소로 걸리는 시간을 찾아야 하는 것이기 때문에 'data[i] = data[x] + 1'처럼 한 번 이동했을 때 1을 더해줌
                data[i] = data[x] + 1
                q.append(i)
print(BFS(n))