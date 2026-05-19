# Write your MySQL query statement below
select (  
    select distinct salary from (  
    select salary , dense_rank() over (order by salary DESC) as Drank from Employee )t  where Drank = 2
) as SecondHighestSalary ;