-- https://javaguide.cn/database/sql/sql-questions-03.html#%E5%BE%97%E5%88%86%E4%B8%8D%E5%B0%8F%E4%BA%8E%E5%B9%B3%E5%9D%87%E5%88%86%E7%9A%84%E6%9C%80%E4%BD%8E%E5%88%86

SELECT exam_id, AVG(score) AS avg_score
FROM exam_record
GROUP BY exam_id

