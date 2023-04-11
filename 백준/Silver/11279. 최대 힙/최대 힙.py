# heapq가 PriorityQueue보다 실행시간이 적게 걸림
import sys
import heapq
# 시간 초과 발생 시 밑에 코드 추가하기
input = sys.stdin.readline
n = int(input())
q = []

for _ in range(n):
    x = int(input())
    # heapq는 최소 힙
    # 내림차순으로 넣고 싶을 때는 원소 부호를 바꿔 삽입하고 원소를 꺼내고 부호를 바꿔 출력
    if x == 0:
        if len(q) > 0:
            print(-heapq.heappop(q))
        else:
            print(0)
    else:
        heapq.heappush(q, -x)