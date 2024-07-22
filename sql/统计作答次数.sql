-- 单行数据的快速写法
SELECT 
    COUNT(1) AS total_pv,
    COUNT(submit_time) AS complete_pv,
--     COUNT
FROM exam_record

