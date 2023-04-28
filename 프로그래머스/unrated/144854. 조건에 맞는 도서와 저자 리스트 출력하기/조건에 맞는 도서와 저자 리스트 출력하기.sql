SELECT A.BOOK_ID, B.AUTHOR_NAME, date_format(A.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK A JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE A.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE