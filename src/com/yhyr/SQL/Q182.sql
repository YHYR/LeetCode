-- 查找重复的电子邮件
SELECT
	Email
FROM
	Person
GROUP BY
	Email
HAVING
	count(Email) > 1