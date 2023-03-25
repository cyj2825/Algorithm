from collections import deque

S, P = map(int, input().split())
DNA = list(input())
A, C, G, T = map(int, input().split())
dic = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
left, right = 0, P-1
arr = deque(DNA[left:right])
for i in arr:      # 마지막 수는 제외하고 구성 => right+1로 하게 되면 마지막에 범위를 넘어가는 오류 발생하므로
    dic[i] += 1
count = 0

while right < S:
    # 마지막 오른쪽 수 추가 => 구간 완성
    dic[DNA[right]] += 1
    
    # 주어진 개수 이상인지 확인 
    if dic['A'] >= A and dic['C'] >= C and dic['G'] >= G and dic['T'] >= T:
        count += 1
    # 구간 한 칸 이동
    dic[DNA[left]] -= 1    # 첫번째 수 제거
    left += 1
    right += 1
print(count)