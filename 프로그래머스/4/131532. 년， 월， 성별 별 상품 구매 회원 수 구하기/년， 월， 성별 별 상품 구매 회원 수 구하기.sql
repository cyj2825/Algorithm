select year(B.SALES_DATE) as YEAR, month(B.SALES_DATE) as MONTH, A.GENDER, count(distinct A.USER_ID) as USERS
from USER_INFO A join ONLINE_SALE B ON A.USER_ID = B.USER_ID
where A.GENDER IS NOT NULL
group by year(B.SALES_DATE), month(B.SALES_DATE), A.GENDER
order by year(B.SALES_DATE), month(B.SALES_DATE), A.GENDER