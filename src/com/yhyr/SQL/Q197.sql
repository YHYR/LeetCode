-- 上升的温度
SELECT
	a.Id AS Id
FROM
	Weather a
JOIN Weather b ON DATEDIFF(a.RecordDate, b.RecordDate) = 1
AND a.Temperature > b.Temperature