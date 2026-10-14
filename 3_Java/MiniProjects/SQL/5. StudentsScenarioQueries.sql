-- Students Table
-- 31.	Find the average marks scored by students in each department. 
select department, AVG(marks) AS Average_Marks from Students GROUP BY department ORDER BY department ASC;
-- 32.	Find departments whose average marks are above 75. 
select department, AVG(marks) AS Average_Marks from Students GROUP BY department HAVING Average_Marks > 75 ORDER BY department ASC;
-- 33.	Find the highest mark scored in each department. 
select department, MAX(marks) AS Highest_Marks from Students GROUP BY department ORDEr BY department ASC;
-- 34.	Find the total number of students in each department. 
select department, COUNT(student_id) from Students GROUP BY department ORDER BY department ASC;
-- 35.	Find departments having more than 5 students. 
select department, Count(student_id) AS Student_Count from Students GROUP BY department HAVING Student_Count > 5 ORDER BY department ASC;
-- 36.	Display departments sorted by average marks in descending order. 
select department, AVG(marks) AS Average_Marks from Students GROUP BY department ORDER BY AVerage_Marks DESC;
-- 37.	Find the top 3 departments based on average marks. 
select department, AVG(marks) AS Average_Marks from Students GROUP BY department ORDER BY AVerage_Marks DESC LIMIT 3;
-- 38.	Find departments whose average marks are between 70 and 90. 
select department, AVG(marks) AS Average_Marks from Students GROUP BY department HAVING Average_Marks BETWEEN 70 AND 90 ORDER BY department ASC;
-- 39.	Find the total marks scored by students in each department. 
select department, SUM(marks) AS TOtal_Marks_Scored from Students GROUP BY department ORDER BY total_Marks_Scored DESC; 
-- 40.	Display departments sorted by the total number of students. 
select department, COUNT(student_id) AS Total_Students from Students GROUP BY department ORDER BY Total_Students ASC;
-- 41.	Find the lowest mark scored in each department. 
select department, MIN(marks) from Students GROUP BY department ORDER BY department ASC;
-- 42.	Find departments where the highest mark is greater than 90. 
select department, MAX(marks) AS Highest_Mark from Students GROUP BY department HAVING Highest_Mark > 90 ORDER BY department ASC;
-- 43.	Find the number of students scoring above 80 in each department. 
select department, COUNT(student_id) AS Student_Count, MIN(marks) from Students WHERE marks > 80 GROUP BY department ORDER BY department ASC; -- used MIN to show that each department has a minimum greater than 80
-- 44.	Find departments where more than 3 students scored above 75. 
select department, COUNT(student_id) AS Student_Count from Students where marks > 75 GROUP BY department HAVING Count(student_id) > 3 ORDEr BY department ASC;
-- 45.	Display departments ordered by highest mark in descending order. 
select department, MAX(marks) AS Highest_Marks from Students GROUP BY department ORDER BY Highest_Marks DESC;