-- 
SELECT 'SQL' AS tag, 'hard' AS difficulty, ROUND((SUM(score) - MAX(score) - MIN(score)) / (COUNT(1) - 2), 1) AS clip_avg_score
FORM (
    SELECT *
    FROM exam_record
    WHERE exam_id IN (
        SELECT exam_id
        FROM examination_info AS t1
        WHERE difficulty = 'hard'
    ) AND score IS NOT NULL
) AS t2




