show databases;
create DATABASE Mini_Project_1;
use Mini_Project_1;
create table customers(
    customer_id int PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    city VARCHAR(50)
);

create table accounts (
    account_id int PRIMARY KEY AUTO_INCREMENT,
    customer_id int,
    account_type VARCHAR(20),
    balance DECIMAL(10,2),

    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

show tables;

insert into customers(name, city) values ('Janani','Chennai'),
('Arun','Coimbatore'),
('Priya','Madurai'),
('Karthik','Salem');

insert into accounts (customer_id, account_type, balance) values(1,'Savings',50000),
(1,'Current',20000),
(2,'Savings',30000),
(3,'Savings',15000),
(4,'Current',40000);

select * from accounts JOIN customers ON customers.customer_id = accounts.customer_id;