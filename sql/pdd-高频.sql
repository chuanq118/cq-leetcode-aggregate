-- https://mp.weixin.qq.com/s/eUmODJHmIXCBhdi-icAFjg
-- uid: 用户ID
-- pay_time: 用户支付下单时间
-- oid: 订单编号
-- amount: 订单金额 
SELECT
    SUM(amount) OVER (PARTITION BY DATE_FORMAT(pay_time, '%Y-%m-%d')) AS day_GMV,
    RANK() OVER (PARTITION BY uid ORDER BY UNIX_TIMESTAMP(DATE_FORMAT(pay_time, '%Y-%m-%d')) ASC RANGE BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING) AS user_history_GMV,
    

FROM
    order_table


