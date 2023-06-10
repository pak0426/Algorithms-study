SELECT
        CAST(DATE_FORMAT(START_DATE, '%y%m') AS UNSIGNED) AS S_DATE,
        CAST(DATE_FORMAT(START_DATE, '%m') AS UNSIGNED) AS MONTH,
        CAR_ID,
        COUNT(*) AS RECORDS
    FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
    CAST(DATE_FORMAT(START_DATE, '%y%m') AS UNSIGNED) >= 2208
    AND CAST(DATE_FORMAT(START_DATE, '%y%m') AS UNSIGNED) <= 2210
    GROUP BY CAST(DATE_FORMAT(START_DATE, '%y%m') AS UNSIGNED), CAR_ID