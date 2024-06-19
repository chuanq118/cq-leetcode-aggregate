WITH T1 AS (
    SELECT DISTINCT customerId
    FROM Orders
)
SELECT 
    name AS Customers
FROM 
    Customers AS C
    INNER JOIN
    T1
    ON C.id = T1.customerId
WHERE
    id NOT IN T1