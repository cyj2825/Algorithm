select CATEGORY, PRICE as MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where regexp_like(CATEGORY, '과자|국|김치|식용유') and (CATEGORY, PRICE) in (select CATEGORY, max(PRICE) from FOOD_PRODUCT group by CATEGORY)
order by PRICE DESC