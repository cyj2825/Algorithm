select BOOK_ID, B.AUTHOR_NAME, date_format(PUBLISHED_DATE, '%Y-%m-%d')
from BOOK A join AUTHOR B on A.AUTHOR_ID = B.AUTHOR_ID
where CATEGORY = '경제'
order by PUBLISHED_DATE