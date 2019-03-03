-- 收入超过经理的员工
SELECT
	a. NAME AS Employee
FROM
	Employee a
JOIN Employee b ON a.ManagerId = b.Id
AND a.Salary > b.Salary