WITH AGG1 AS (
    SELECT
        departmentId AS dep_id,
        MAX(salary) as max_salary
    FROM
        Employee
    GROUP BY
        departmentId
)
SELECT
    Dep.name AS Department,
    Emp.name AS Employee,
    AGG1.max_salary AS Salary
FROM
    Employee AS Emp
    INNER JOIN
    Department AS Dep
    ON Emp.departmentId = Dep.id
    INNER JOIN
    AGG1 ON Emp.departmentId = AGG1.dep_id
WHERE
    Emp.salary = AGG1.max_salary