# Write your MySQL query statement below
SELECT e.id FROM Weather e
JOIN Weather c
ON (DATEDIFF(e.recordDate , c.recordDate) = 1)
AND e.temperature > c.temperature;