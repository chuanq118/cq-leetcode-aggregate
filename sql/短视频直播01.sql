-- https://cloud.tencent.com/developer/article/2047532

-- 找出每个用户点赞数最高的视频，点赞数相同时按照视频 id 最大的记录

-- 写法1:
-- 参考这篇博客 理解 GROUP BY + ORDER BY 一起使用时的问题 (https://blog.csdn.net/guo_qiangqiang/article/details/108492698)
SELECT *
FROM
(
     SELECT *
     FROM user_video_table
     ORDER BY likes, vid
 ) AS T1
GROUP BY uid

-- 写法2:
WITH t2 AS (
    SELECT
        t1.*,
        ROW_NUMBER() OVER (
            PARTITION BY uid ORDER BY likes, vid DESC
        ) AS rank
    FROM user_video_table AS t1
)
SELECT *
FROM t2
WHERE t2.rank = 1

-- #############################
-- 找出粉丝数在6月2号提升最多的3个用户id
WITH tmp1 AS (
    SELECT uid, MAX(fans)
    FROM user_video_table
    WHERE DATE_FORMAT(publish_date, '%m-%d') = '06-02'
    GROUP BY uid
)
tmp2 AS (
--     SELECT
--         MAX() OVER (PARTITION BY t1.uid WHERE )
--     FROM
--         user_video_table AS t1
--         INNER JOIN
--         tmp1 ON t1.uid = tmp1.uid
)
-- ... 传统写法即可


-- ###################
-- 找出开播三分钟内无人进入的直播房间号
SELECT
    DISTINCT sid
FROM
    streamer_open AS t1 LEFT JOIN user_liveroom AS t2
    ON t1.room_id = t2.room_id
WHERE
    TIMESTAMPDIFF(MINUTE, t1.open_time, t2.in_time) <= 3


