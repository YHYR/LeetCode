-- 分数排名
SELECT
	t.Score,
	CONVERT (t.Rank, SIGNED) AS Rank
FROM
	(
		SELECT
			Score,

		IF (
			@score = Score,
			@rank,
			@rank :=@rank + 1
		) AS Rank,
		@score := Score
	FROM
		Scores a,
		(
			SELECT
				@score := NULL,
				@rank := 0
		) b
	ORDER BY
		Score DESC
	) t