-- 第二高薪
-- Way 1：通过Max()函数
SELECT
	Max(Salary) AS SecondHighestSalary
FROM
	Employee
WHERE
	Salary <> (
		SELECT
			Max(Salary)
		FROM
			Employee
	);

-- Way 2：通过子查询筛选第二稿薪水；该解法无法Accept，因为对于不存在第二高薪水返回结果不是Null
SELECT
	salary as SecondHighestSalary
FROM
	Employee
WHERE
	salary < (
		SELECT
			salary
		FROM
			Employee
		ORDER BY
			salary DESC
		LIMIT 1
	)
ORDER BY
	salary DESC
LIMIT 1;

-- Way 3：通过order by + limit + offset实现筛选
SELECT DISTINCT
	salary as SecondHighestSalary
FROM
	Employee
ORDER BY
	salary DESC
LIMIT 1 OFFSET 1;

-- 方法2和方法3在无第二高薪水的场景下均无法通过Accept；因为返回值不满足题目要求；可以通过IFNULL()函数解决，以Way 3为例：
SELECT
	IFNULL(
			(
				SELECT DISTINCT
					salary
				FROM
					Employee
				ORDER BY
					salary DESC
				LIMIT 1 OFFSET 1
			),
			NULL
	) AS SecondHighestSalary;