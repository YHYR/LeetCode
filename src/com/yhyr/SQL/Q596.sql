-- 超过五名学生的课
SELECT
	class
FROM
	(SELECT DISTINCT * FROM courses) a
GROUP BY
	class
HAVING
	count(1) >= 5