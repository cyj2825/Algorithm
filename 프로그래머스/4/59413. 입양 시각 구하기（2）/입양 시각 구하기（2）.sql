# 로컬 변수 활용(SET 옆에 변수명은 초기값을 설정할 수 있다)
SET @hour := -1; # 변수 선언(:= 은 대입연산)

SELECT (@hour := @hour + 1) as HOUR,
(SELECT COUNT(*) FROM ANIMAL_OUTS WHERE HOUR(DATETIME) = @hour) as COUNT
FROM ANIMAL_OUTS
WHERE @hour < 23