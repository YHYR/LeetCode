-- 第二高薪
-- Way 1：通过两次max()函数实现
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

-- Way 2：通过子查询筛选第二稿薪水；max() + order by
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

-- Way 3：通过order by + limit + offset实现筛选 => 推荐写法，灵活性高
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