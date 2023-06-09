-- 코드를 입력하세요
SELECT
    A.CAR_ID
    ,IFNULL(B.AVAILABILITY, '대여 가능') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
LEFT OUTER JOIN
(
    SELECT
        HISTORY_ID,
        CAR_ID,
        '대여중' AS AVAILABILITY
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE 
        DATE_FORMAT(START_DATE, '%Y%m%d') <= '20221016'
    AND DATE_FORMAT(END_DATE, '%Y%m%d') >= '20221016'
)B
ON A.CAR_ID = B.CAR_ID
GROUP BY CAR_ID
ORDER BY CAR_ID DESC
;