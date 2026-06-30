-- 코드를 입력하세요
SELECT f.FLAVOR
from ( select FLAVOR, SUM(TOTAL_ORDER) AS TOT
     from JULY j
     group by FLAVOR ) j 
     join FIRST_HALF f on j.FLAVOR = f.FLAVOR
group by f.FLAVOR
order by j.TOT + f.TOTAL_ORDER desc
LIMIT 3;

