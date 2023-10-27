select A.CATEGORY, sum(B.SALES) as TOTAL_SALES
from BOOK A join BOOK_SALES B on A.BOOK_ID = B.BOOK_ID
where date_format(B.SALES_DATE, '%Y-%m') = '2022-01'
group by A.CATEGORY
order by A.CATEGORY