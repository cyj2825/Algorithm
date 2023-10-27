select ANIMAL_TYPE, IF(NAME is null, 'No name', NAME) as NAME, SEX_UPON_INTAKE
from ANIMAL_INS
order by ANIMAL_ID