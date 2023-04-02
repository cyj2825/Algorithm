# 다시보기
# 병합 정렬 사용
import sys
input = sys.stdin.readline
result = 0

n = int(input())
A = list(map(int, input().split()))     # 정렬할 리스트
A.insert(0,0)     # 0번째 인덱스에 0 넣기
tmp = [0] * (n+1)

def merge_sort(s, e):
    global result
    # 더이상 자를 수 없을 경우
    if e-s < 1: return
    m = int(s+(e-s)/2)
    merge_sort(s,m)
    merge_sort(m+1,e)
    for i in range(s, e+1):
        tmp[i] = A[i]
        
    k = s          # A 배열에서 어느 위치에 데이터가 들어가야하는지 나타내주는 인덱스
    index1 = s     # 앞쪽 그룹 시작점
    index2 = m+1   # 뒤쪽 그룹 시작점
    while index1 <= m and index2 <= e:
        if tmp[index1] > tmp[index2]:
            A[k] = tmp[index2]
            # swap count
            result += index2-k     # index2-k : 남아있는 1번 data set의 데이터의 개수
            k += 1
            index2 += 1
        else:
            A[k] = tmp[index1]
            k += 1
            index1 += 1
    # 하나의 data set만 모두 종료됐을 경우 고려
    while index1 <= m:
        A[k] = tmp[index1]
        k += 1
        index1 += 1
    while index2 <= e:
        A[k] = tmp[index2]
        k += 1
        index2 += 1
        
merge_sort(1, n)    # 1번째 인덱스부터 n번째 인덱스까지 병합 정렬
print(result)