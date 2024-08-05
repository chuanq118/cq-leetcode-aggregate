WITH T1 AS (
    SELECT
        uid,
        login_date,
        DENSE_RANK() OVER (PARTITION BY uid ORDER BY login_date ASC) AS rn
    FROM user_login
)
SELECT uid
FROM T1
GROUP BY
    uid, DATE_SUB(login_date, INTERVAL rn DAY)
HAVING COUNT(1) >= 3