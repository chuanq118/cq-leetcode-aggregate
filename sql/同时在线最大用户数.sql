-- https://mp.weixin.qq.com/s/akrXQV-6rR4jaM24CV8QKQ

-- 下面这种写法是错误❎的,注意需要的结果是按分钟进行统计的!
-- WITH T2 AS (
--     SELECT
--         room_id,
--         uid,
--         log_in_tm AS tm,
--         op
--     FROM
--         (
--             SELECT
--                 room_id, uid, log_in_tm, 1 AS op
--             FROM user_log
--             UNION ALL
--             SELECT 
--                 room_id, uid, log_out_tm, -1 AS op
--             FROM user_log
--         ) AS T1
--     ORDER BY log_in_tm ASC
-- )
-- GROUP BY room_id



WITH T2 AS (
    SELECT
        room_id,
        uid,
        di,
        op
    FROM
        (
            SELECT
                room_id,
                uid,
                DATE_FORMAT(log_in_tm, '%Y-%m-%d %H:%i') AS di,
                1 AS op
            FROM user_log
            UNION ALL
            SELECT 
                room_id,
                uid,
                DATE_FORMAT(log_out_tm, '%Y-%m-%d %H:%i') AS di,
                -1 AS op
            FROM user_log
        ) AS T1
    ORDER BY di ASC
)
T3 AS (
    SELECT room_id, di, SUM(op) as cnt
    FROM T2
    GROUP BY room_id, di
)
SELECT MAX(cnt) AS max_cnt
FROM T3
GROUP BY room_id
