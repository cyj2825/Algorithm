select CONCAT('/home/grep/src/', B.BOARD_ID, '/', B.FILE_ID, B.FILE_NAME, B.FILE_EXT) as FILE_PATH
from USED_GOODS_BOARD A join USED_GOODS_FILE B on A.BOARD_ID = B.BOARD_ID
where A.VIEWS = (select MAX(VIEWS) from USED_GOODS_BOARD)
order by B.FILE_ID desc