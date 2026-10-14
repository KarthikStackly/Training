-- Employee Table
-- 1.	Find the total number of employees in each department. 
select department, COUNT(emp_id) from employee GROUP BY department ORDER BY department DESC; -- Order by not required, added so that it has Some order...
-- 2.	Find the average salary of employees in each department.
select department, AVG(salary) from employee GROUP by department ORDER BY department ASC;
-- 3.	Display departments having more than one employee.
select department, COUNT(emp_id) AS Number_Of_Employees from employee GROUP BY department HAVING COUNT(emp_id) > 1 ORDER BY department DESC;
-- 4.	Find the highest salary in each department.
select department, MAX(salary) AS Highest_Salary from employee GROUP BY department ORDEr BY department ASC;
-- 5.	Find the lowest salary in each department.
select department, MIN(salary) AS Lowest_Salary from employee GROUP BY department ORDEr BY department ASC;
-- 6.	Find departments whose average salary is greater than 50,000. 
select department, AVG(salary) from employee GROUP BY department HAVING AVG(Salary) > 50000 ORDER BY AVG(Salary) DESC;
-- 7.	Calculate the total salary expenditure for each department.
SELECT department, SUM(salary) AS Total_Salary_Expenditure from employee group by department ORDER BY TOtal_Salary_Expenditure DESC;
-- 8.	Display all employees sorted by salary in descending order.
select * from employee ORDER BY salary DESC;
-- 9.	Display employees sorted first by department and then by salary in descending order. 
select * from employee ORDER BY department DESC, salary DESC; -- assuming both are in descending order. Need to be mentioned separately for each, otherwise default order takes over... 
-- OR
select * from employee ORDER BY department, salary DESC; -- assuming only salary in descending order
-- 10.	Find cities that have more than one employee. 
select city from employee GROUP BY city HAVING COUNT(emp_id) > 1;
-- 11.	Find the total salary paid in each city. 
select city, SUM(salary) AS Total_Salary_Per_City from employee GROUP BY city ORDER BY Total_Salary_Per_City DESC;
-- 12.	Display departments ordered by total salary expenditure from highest to lowest. 
select department, SUM(salary) AS Total_Salary_Expenditure from employee GROUP BY department ORDER BY Total_Salary_Expenditure DESC;
-- 13.	Find the number of employees in each department whose salary is greater than 50,000.
select department, COUNT(emp_id) AS Number_Of_Employees from employee where salary > 50000 GROUP BY department ORDER BY department DESC;
-- 14.	Find the difference between the highest and lowest salary in each department. 
select department, MAX(salary) - MIN(salary) AS Difference_Of_Highest_Lowest from employee GROUP BY department ORDER BY department ASC;
-- 15.	Display the top 3 highest-paid employees. 
select * from employee ORDER BY salary DESC LIMIT 3;