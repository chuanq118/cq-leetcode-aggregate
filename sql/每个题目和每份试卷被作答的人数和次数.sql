-- https://javaguide.cn/database/sql/sql-questions-03.html#%E6%AF%8F%E4%B8%AA%E9%A2%98%E7%9B%AE%E5%92%8C%E6%AF%8F%E4%BB%BD%E8%AF%95%E5%8D%B7%E8%A2%AB%E4%BD%9C%E7%AD%94%E7%9A%84%E4%BA%BA%E6%95%B0%E5%92%8C%E6%AC%A1%E6%95%B0

(
    SELECT
        exam_id AS tid,
        COUNT(DISTINCT uid) AS uv,
        COUNT(1) AS pv
    FROM
        exam_record
    GROUP BY
        exam_id
    ORDER BY
        uv, pv DESC
)
UNION ALL
(
    SELECT
        question_id AS tid,
        COUNT(DISTINCT uid) AS uv,
        COUNT(1) AS pv
    FROM
        practice_record
    GROUP BY
        question_id
    ORDER BY
        uv, pv DESC
)

