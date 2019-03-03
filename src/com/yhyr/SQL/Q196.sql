-- 删除重复的电子邮件
DELETE
FROM
	Person
WHERE
	Id NOT IN (
		SELECT
			minId
		FROM
			(
				SELECT
					min(id) AS minId
				FROM
					Person
				GROUP BY
					Email
			) t
	)