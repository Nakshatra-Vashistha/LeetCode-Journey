-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
--     SET N = N-1;
--   RETURN (
--       # Write your MySQL query statement below.
--       SELECT distinct salary 
--       FROM Employee
--       ORDER BY salary DESC
--       LIMIT 1 OFFSET N

--   );
-- END

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN

    SET N = N - 1;

    RETURN (
        WITH cte AS (
            SELECT DISTINCT salary
            FROM Employee
            ORDER BY salary DESC
            LIMIT 1 OFFSET N
        )

        SELECT salary FROM cte
    );

END