-- https://www.nowcoder.com/discuss/648809044886532096?sourceSSR=dynamic

-- 有一张用户登录日志表 ods_usr_login_log, 包含user_id（用户id）、 login_dt （登录日期），一个用户当天可能登录多次
-- 问题：计算存在新用户登录的日期的次日留存率以及3日留存率
-- N日留存用户数：某日活跃的用户在之后的第N日活跃用户数

WITH TB1 AS (
    SELECT DISTINCT fir_login_dt
    FROM (
        SELECT MIN(login_dt) AS fir_login_dt
        -- ...
    )
)
SELECT

    TIMESTAMPDIFF(DAY, t1.login_dt, t2.login_dt) = 1
FROM
    ods_usr_login_log AS t1
    INNER JOIN
    TB1 AS t2 ON t1.login_dt = t2.fir_login_dt


