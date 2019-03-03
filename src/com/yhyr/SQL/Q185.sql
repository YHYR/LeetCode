-- 部门工资前三年的员工
# Write your MySQL query statement below

SELECT
	d. NAME AS Department,
	r. NAME AS Employee,
	r.Salary
FROM
	Department d
JOIN (
	SELECT
		e. NAME,
		e.Salary,
		e.DepartmentId,
	IF (
		@departmentId = e.DepartmentId,

	IF (
		@sal = e.Salary,
		@rank,
		@rank :=@rank + 1
	),
	@rank := 1
	) AS rank,
	@departmentId := e.DepartmentId,
	@sal := e.Salary
FROM
	Employee e,
	(
		SELECT
			@departmentId := NULL,
			@rank := 0,
			@sal := NULL
	) t
ORDER BY
	e.DepartmentId,
	e.Salary DESC
) r ON d.Id = r.DepartmentId
WHERE
	rank <= 3