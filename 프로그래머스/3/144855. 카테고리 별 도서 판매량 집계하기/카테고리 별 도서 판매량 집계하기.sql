-- 코드를 입력하세요
SELECT b.CATEGORY, SUM(bs.SALES) as TOTAL_SALES
from BOOK_SALES as bs
left join
BOOK as b
on b.BOOK_ID = bs.BOOK_ID
where bs.SALES_DATE like '2022-01%'
group by b.CATEGORY
order by b.CATEGORY ASC;