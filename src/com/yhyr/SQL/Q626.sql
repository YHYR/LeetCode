-- 换座位
SELECT
IF (b.id IS NULL, a.id, b.id) AS id,
 a.student
FROM
	seat a
LEFT JOIN seat b ON
IF (
	MOD (a.id, 2) = 1,
	a.id + 1 = b.id,
	a.id - 1 = b.id
)