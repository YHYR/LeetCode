-- 组合两个表
SELECT
	FirstName,
	LastName,
	City,
	State
FROM
	Person
LEFT JOIN Address ON Person.PersonId = Address.PersonId;