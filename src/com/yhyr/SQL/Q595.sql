-- 大的国家
SELECT
	NAME,
	population,
	area
FROM
	World
WHERE
	area > 3000000
OR population > 25000000