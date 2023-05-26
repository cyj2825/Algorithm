SELECT hour(DATETIME) AS HOUR, count(ANIMAL_ID) AS COUNT
FROM ANIMAL_OUTS
WHERE hour(DATETIME) between 9 and 19
GROUP BY hour(DATETIME)
ORDER BY HOUR