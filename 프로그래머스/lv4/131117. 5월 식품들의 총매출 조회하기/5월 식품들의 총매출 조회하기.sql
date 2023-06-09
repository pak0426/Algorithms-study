-- 코드를 입력하세요
SELECT
     AA.PRODUCT_ID
    ,AA.PRODUCT_NAME
    ,SUM(TOTAL_SALES) AS TOTAL_SALES
FROM
(
SELECT
     A.PRODUCT_ID
    ,A.PRODUCT_NAME
    ,(A.PRICE * B.AMOUNT) AS TOTAL_SALES
FROM FOOD_PRODUCT A
JOIN FOOD_ORDER B
ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE DATE_FORMAT(B.PRODUCE_DATE, '%Y%m') = '202205'
)AA
GROUP BY AA.PRODUCT_ID, AA.PRODUCT_NAME
ORDER BY SUM(TOTAL_SALES) DESC, PRODUCT_ID
;