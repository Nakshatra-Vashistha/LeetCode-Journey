# Write your MySQL query statement below
with cte as (
    select email,count(*) as cnt  
    from Person 
    GROUP BY email
    
)
select email as Email
from cte 
where cnt > 1;