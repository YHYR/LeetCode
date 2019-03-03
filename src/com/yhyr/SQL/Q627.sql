-- 交换工资
UPDATE salary
SET sex = CASE sex
WHEN 'm' THEN
	'f'
ELSE
	'm'
END;