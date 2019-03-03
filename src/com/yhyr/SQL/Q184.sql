-- 部门中工资最高的员工
SELECT
	d. NAME AS Department,
	e. NAME AS Employee,
	e.Salary
FROM
	Employee e
JOIN (
	SELECT
		Max(Salary) AS Salary,
		DepartmentId
	FROM
		Employee
	GROUP BY
		DepartmentId
) t
JOIN Department d ON e.Salary = t.Salary
AND e.DepartmentId = t.DepartmentId
AND e.DepartmentId = d.Id