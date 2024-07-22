-- https://mp.weixin.qq.com/s/k9de-Be1GWPC6DVraIQ8rQ
SELECT
    store_id,
    dt,
    cnt,
    SUM(cnt) OVER (PARTITION BY store_id ORDER BY dt ASC) AS accumulate_cnt
FROM sales