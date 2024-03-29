SELECT A.PRODUCT_ID, A.PRODUCT_NAME, sum(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A JOIN FOOD_ORDER B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE date_format(B.PRODUCE_DATE,'%Y-%m') = '2022-05'
GROUP BY A.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, A.PRODUCT_ID
