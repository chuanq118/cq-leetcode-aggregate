SELECT
    T2.name AS Employee
FROM
    Employee T1
    LEFT JOIN
    Employee T2
    ON T1.id = T2.managerId
WHERE
    T1.salary < T2.salary