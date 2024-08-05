-- https://javaguide.cn/database/sql/sql-questions-03.html#%E6%9C%88%E6%80%BB%E5%88%B7%E9%A2%98%E6%95%B0%E5%92%8C%E6%97%A5%E5%9D%87%E5%88%B7%E9%A2%98%E6%95%B0
-- 获取月份的具体天数

SELECT
    DATE_FORMAT(submit_time, '%Y%m') AS submit_month,
    COUNT(1) AS month_q_cnt,
    COUNT(1) / DAYS()
FROM practice_record
WHERE YEAR(submit_time) = 2021
GROUP BY DATE_FORMAT(submit_time, '%Y%m')


