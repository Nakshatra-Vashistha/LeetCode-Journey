WITH RECURSIVE TreeHierarchy AS (
    SELECT id, p_id, 1 AS depth
    FROM Tree
    WHERE p_id IS NULL
    
    UNION ALL
    
   SELECT t.id, t.p_id, th.depth + 1 AS depth
    FROM Tree t
    JOIN TreeHierarchy th ON t.p_id = th.id
)


SELECT th.id,
    CASE 
        WHEN th.p_id IS NULL THEN 'Root'
        WHEN th.id IN (SELECT DISTINCT p_id FROM TreeHierarchy) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM TreeHierarchy th;