-- https://www.nowcoder.com/discuss/642472522826403840?sourceSSR=users
-- 有一张用户行为日志表ods_usr_log, 包含用户id（user_id）和页面id（page_id）以及进入页面时间（in_ts）
-- 问题：统计每天进入A页面后，立刻进入B页面，又进入C页面的用户数【注意：进入C页面之前可能进入过其他页面】

WITH tb1 AS (
    SELECT user_id, MIN(in_ts) AS in_ts_a_fir
    FROM ods_usr_log
    WHERE page_id = 'A'
    GROUP BY user_id
)
WITH tb2 AS (
    SELECT
        -- ...
    FROM
        tb1 INNER JOIN
        ods_usr_log AS tmp1
        ON tb1.user_id = tmp1.user_id
    WHERE
        tb1.in_ts_a_fir < tmp1.in_ts
)
-- rank

--  2: concat_ws(',', collect_list())


