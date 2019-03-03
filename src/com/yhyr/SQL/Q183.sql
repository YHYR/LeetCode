-- 从不订购的客户
SELECT
	NAME AS Customers
FROM
	Customers
WHERE
	Id NOT IN (SELECT CustomerId FROM Orders)