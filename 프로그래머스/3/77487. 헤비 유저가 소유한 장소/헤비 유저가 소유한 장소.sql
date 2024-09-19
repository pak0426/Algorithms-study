-- 코드를 입력하세요
select
    *
from PLACES
where
host_id in
(
    select
        host_id
    from PLACES
    group by host_id
    having count(host_id) >= 2
)
order by id
;