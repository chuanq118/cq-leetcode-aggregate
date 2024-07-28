-- https://mp.weixin.qq.com/s/RTOAFcVw2EjeYiPQ7PdLlg

WITH T2 AS (
    SELECT from_user, to_user
    FROM fans, LATERAL TABLE explode(to_user_array) AS T1(to_user)
)
SELECT COUNT(1) AS ans
FROM T2 AS T3 INNER JOIN T2 AS T4
    ON T3.from_user = T4.to_user AND T3.to_user = T4.from_user


