-- https://javaguide.cn/database/sql/sql-questions-03.html#%E5%B9%B3%E5%9D%87%E6%B4%BB%E8%B7%83%E5%A4%A9%E6%95%B0%E5%92%8C%E6%9C%88%E6%B4%BB%E4%BA%BA%E6%95%B0
--  使用COUNT(DISTINCT uid, DATE_FORMAT(submit_time, '%Y%m%d')) 可以统计在 uid 列和 submit_time 列按照年份、月份和日期进行格式化后的组合值的数量。
SELECT
    DATE_FORMAT(start_time, '%Y-%m') AS `month`,
    -- 用户平均月活跃天数 `avg_active_days` !!! 这个数值的计算不太会
    COUNT(DISTINCT uid) AS mau
FROM exam_record
WHERE YEAR(start_time) = 2021
GROUP BY DATE_FORMAT(start_time, '%Y-%m')
