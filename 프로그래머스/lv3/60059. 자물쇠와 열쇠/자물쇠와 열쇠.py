# key를 90도 회전하고 회전값을 리턴하는 함수
def rotation(arr):
    n = len(arr)
    new_key = [[0] * n for _ in range(n)]
    
    for i in range(n):
        for j in range(n):
            # 회전 후 배열의 X 인덱스 == 회전하기 전 배열의 Y 인덱스
            # 회전 후 배열의 Y 인덱스 == (배열 크기 - 1) - 회전하기 전 배열의 X 인덱스
            new_key[j][n-1-i] = arr[i][j]
    return new_key

# 자물쇠가 열리는지 체크하는 함수
def check(startX, startY, key, lock, expendSize, start, end):
    expendList = [[0] * expendSize for _ in range(expendSize)]
    
    # expendList에 key 추가
    for i in range(len(key)):
        for j in range(len(key)):
            expendList[startX + i][startY + j] += key[i][j]
    
    # expendList에 lock 추가하면서 기존 값이랑 더하기
    for i in range(start, end):
        for j in range(start, end):
            expendList[i][j] += lock[i - start][j - start]
            # 자물쇠가 전부 1로만 채워져 있다면 정답
            if expendList[i][j] != 1:
                return False
    return True

def solution(key, lock):
    # expendList에서 lock의 시작 지점
    start = len(key) - 1
    # expendList에서 lock의 종료 지점
    end = start + len(lock)
    # expendList 배열의 크기
    expendSize = len(lock) + start * 2

    # lock은 고정이고 key를 움직여서 탐색하는 것
    # 0, 1, 2, 3 => 90도, 180도, 270도, 360도 회전
    for x in range(0, 4):
        for i in range(end):
            for j in range(end):
                # check 함수로부터 1값을 받을 경우 True를 반환
                if check(i, j, key, lock, expendSize, start, end):
                    return True
        key = rotation(key)
    return False