SELECT A.AUTHOR_ID, B.AUTHOR_NAME, A.CATEGORY, sum(A.PRICE * C.SALES) as TOTAL_SALES
FROM BOOK A LEFT JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
LEFT JOIN BOOK_SALES C ON A.BOOK_ID = C.BOOK_ID
WHERE date_format(C.SALES_DATE, '%Y-%m') = '2022-01'
GROUP BY A.AUTHOR_ID, A.CATEGORY
ORDER BY A.AUTHOR_ID, A.CATEGORY DESC