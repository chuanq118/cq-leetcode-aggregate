-- https://javaguide.cn/database/sql/sql-questions-03.html#%E6%AF%8F%E4%B8%AA-6-7-%E7%BA%A7%E7%94%A8%E6%88%B7%E6%B4%BB%E8%B7%83%E6%83%85%E5%86%B5-%E5%9B%B0%E9%9A%BE

WITH t1 AS (
    SELECT DISTINCT uid
    FROM user_info
    WHERE level = 6 OR level = 7
)
SELECT
    
FROM
    t1 INNER JOIN exam_record AS t2
    ON t1.uid = t2.uid
    INNER JOIN practice_record AS t3
    ON t1.uid = t3.uid
WHERE
    YEAR(t2.start_time) = 2021
    AND
    YEAR(t3.submit_time) = 2021
GROUP BY
    t1.uid
