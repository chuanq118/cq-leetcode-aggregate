-- https://mp.weixin.qq.com/s/k9de-Be1GWPC6DVraIQ8rQ
-- mark, 思路简单, 函数/方法 不常用
SELECT
    store_id,
    dt,
    cnt,
    -- 注意是每天的 累计 销量
    SUM(cnt) OVER (PARTITION BY store_id ORDER BY dt ASC) AS accumulate_cnt,
    -- 近三日均销
    SUM(cnt) OVER (PARTITION BY store_id ORDER BY dt ASC )
FROM sales