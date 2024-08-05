WITH agg1 AS (
    SELECT 
        T1.*,
        T2.tag
    FROM
        exam_record AS T1 LEFT JOIN examination_info AS T2
        ON T1.exam_id = T2.exam_id
    WHERE YEAR(T1.start_time) = 2021
    ORDER BY T1.start_time ASC
)
SELECT
    uid,
    SUM(IF(submit_time IS NULL, 1, 0)) AS incomplete_cnt,
    SUM(IF(submit_time IS NOT NULL, 1, 0)) AS complete_cnt,
    CONCAT(IF(submit_time IS NULL, CONCAT(DATE_FORMAT(T1.start_time, '%Y-%m-%d'), )))
FROM
    agg1
GROUP BY
    uid
HAVING
    ...
ORDER BY
    ...