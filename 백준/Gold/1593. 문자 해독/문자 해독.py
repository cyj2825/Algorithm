# 슬라이딩 위도우 사용
import sys
input = sys.stdin.readline
# w의 길이, 문자열 S의 길이
w, s = map(int, input().split())
# w의 문자열
# 공백,\n 제거를 위해 strip() 사용
word = input().strip()
# S의 문자열
sentence = input().strip()
# 알파벳 52개를 배열을 이용하여 비교
w_state = [0] * 52
s_state = [0] * 52
count = 0

for i in word:
    # 소문자는 0~25, 대문자는 26~51번 인덱스에 넣기
    if 'a' <= i <= 'z':
        w_state[ord(i) - ord('a')] += 1
    else:
        w_state[ord(i) - ord('A') + 26] += 1

length, start = 0, 0
for i in sentence:
    if 'a' <= i <= 'z':
        s_state[ord(i) - ord('a')] += 1
    else:
        s_state[ord(i) - ord('A') + 26] += 1
    length += 1
    # length의 길이가 W의 길이만큼 되면
    if length == w:
        if w_state == s_state:
            count += 1
        # 첫번째로 저장된 문자의 개수를 제거하고 start값을 1 증가
        if 'a' <= sentence[start] <= 'z':
            s_state[ord(sentence[start]) - ord('a')] -= 1
        else:
            s_state[ord(sentence[start]) - ord('A') + 26] -= 1

        length -= 1
        start += 1
print(count)