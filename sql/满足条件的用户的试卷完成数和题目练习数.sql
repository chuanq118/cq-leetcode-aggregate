WITH agg1 AS (
    SELECT
        t1.uid
    FROM
        user_info AS t1
        LEFT JOIN
        exam_record AS t2
        ON t1.uid = t2.uid
        LEFT JOIN
        examination_info AS t3
        ON t2.exam_id = t3.exam_id
    WHERE
        t1.level = 7
        AND
        t3.tag = 'SQL'
        AND
        t3.difficulty = 'hard'
    GROUP BY
        t1.uid
    HAVING
        AVG(score) > 80
)
SELECT
FROM
WHERE

