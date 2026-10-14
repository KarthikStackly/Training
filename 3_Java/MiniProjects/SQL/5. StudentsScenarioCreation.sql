create table Students(
    student_id int PRIMARY KEY,
    student_name VARCHAR(50),
    department VARCHAR(30),
    marks INT
);

-- insert into Students values();
INSERT INTO Students (student_id, student_name, department, marks) VALUES
-- Computer Science (6 students)
(1, 'Aarav Kumar', 'Computer Science', 96),
(2, 'Diya Sharma', 'Computer Science', 90),
(3, 'Kabir Mehta', 'Computer Science', 85),
(4, 'Riya Patel', 'Computer Science', 80),
(5, 'Arjun Singh', 'Computer Science', 75),
(6, 'Neha Joshi', 'Computer Science', 70),

-- Electronics (4 students)
(7, 'Aditya Rao', 'Electronics', 91),
(8, 'Pooja Nair', 'Electronics', 84),
(9, 'Rahul Deshmukh', 'Electronics', 78),
(10, 'Ananya Sen', 'Electronics', 76),

-- Civil (2 students)
(11, 'Rohan Verma', 'Civil', 92),
(12, 'Kavya Iyer', 'Civil', 88),

-- Mechanical (3 students)
(13, 'Siddharth Roy', 'Mechanical', 70),
(14, 'Tanvi Kulkarni', 'Mechanical', 65),
(15, 'Nikhil Agarwal', 'Mechanical', 55),

-- Biotech (2 students)
(16, 'Shreya Banerjee', 'Biotech', 60),
(17, 'Varun Pillai', 'Biotech', 50);

select * from Students;