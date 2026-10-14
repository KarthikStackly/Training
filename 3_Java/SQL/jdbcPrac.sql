create database jdbcPrac;
use jdbcPrac;
create table Emp_table(empid int primary key AUTO_INCREMENT, empname varchar(50), email varchar(50));
select * from emp_table;

create table students(
    studentID int primary key AUTO_INCREMENT, 
    name varchar(50), 
    email varchar(50)
);

alter table students modify email varchar(50) unique;

select * from students;
show create table students;