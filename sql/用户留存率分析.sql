-- https://mp.weixin.qq.com/s/tZ6dv7fGHNTw7gzSB0fchw
-- 用户日志表 user_log, uid 用户id, dt 用户登陆日期

-- way1: 利用 LAG / LEAD 窗口函数
WITH T1 AS (
    SELECT
        COUNT(DISTINCT uid) AS u_cnt,
        dt
    FROM
        user_log
    GROUP BY
        dt
),
T2 AS (
    SELECT
        dt,
        u_cnt,
        LEAD(u_cnt, 1) OVER (ORDER BY dt ASC) AS next_u_cnt
    FROM T1
    ORDER BY dt ASC
)
SELECT
    dt,
    CONCAT(ROUND(next_u_cnt / u_cnt, 2) * 100, '%') AS user_retention_rate
FROM T2

-- way2: 日期作差自联



