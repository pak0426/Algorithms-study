SELECT
    COUNT(*) AS COUNT
FROM
(
    SELECT 
        GENOTYPE,
        CONV(GENOTYPE, 10, 2) AS binary_genotype,
        (GENOTYPE & 8) DIV 8 AS bit_4,
        (GENOTYPE & 4) DIV 4 AS bit_3,
        (GENOTYPE & 2) DIV 2 AS bit_2,
        GENOTYPE & 1 AS bit_1
    FROM ECOLI_DATA
) A
WHERE 
bit_2 = 0 
AND (bit_1 = 1 OR bit_3 = 1)
;