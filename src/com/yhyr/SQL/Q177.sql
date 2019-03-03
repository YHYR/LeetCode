-- 第N高薪
CREATE FUNCTION getNthHighestSalary (N INT) RETURNS INT
BEGIN
	RETURN (
		-- Write your MySQL query statement below.
		SELECT DISTINCT
			b.Salary
		FROM
			(
				SELECT
					Id,
					Salary,

				IF (
					@sal = Salary,
					@rank,
					@rank :=@rank + 1
				) AS rank,
				@sal := Salary
			FROM
				Employee e,
				(SELECT @sal := NULL, @rank := 0) a
			ORDER BY
				Salary DESC
			) b
		WHERE
			b.rank = N
	);
END