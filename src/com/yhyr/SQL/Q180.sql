-- 连续出现的数字
SELECT DISTINCT
	Num AS ConsecutiveNums
FROM
	(
		SELECT
			Num,
		IF (
			@VALUE = Num,
			@count :=@count + 1,
			@count := 1
		) AS count,
		@VALUE := Num
	FROM
		LOGS l,
		(
			SELECT
				@VALUE := NULL,
				@count := 0
		) a
	) b
WHERE
	count >= 3