select B.USER_ID, B.NICKNAME, CONCAT(B.CITY, " ", B.STREET_ADDRESS1, " ", B.STREET_ADDRESS2) as 전체주소, CONCAT(LEFT(B.TLNO,3), '-', SUBSTR(B.TLNO, 4, 4), '-', RIGHT(B.TLNO, 4)) as 전화번호
from USED_GOODS_BOARD A join USED_GOODS_USER B on A.WRITER_ID = B.USER_ID
group by A.WRITER_ID
having count(*) >= 3
order by B.USER_ID desc