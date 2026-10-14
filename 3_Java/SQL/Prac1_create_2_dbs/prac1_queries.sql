show DATABASES;
create DATABASE karbank;
use karbank;
show tables;
create table customers(
    customer_id int PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(100) not null,
    mobile VARCHAR(10) not null UNIQUE,
    email varchar(50) UNIQUE,
    city varchar(50) DEFAULT 'Hyderabad'
);

select * from customers;

create table accounts (
account_id int primary key AUTO_INCREMENT,
account_no varchar(20) not NULL UNIQUE, 
account_type VARCHAR(20) not null check (account_type IN ('Savings', 'Current')),
balance DECIMAL(12,2) DEFAULT 0.00 check(balance >= 0),
customer_id int not null,

CONSTRAINT fk_account_customer
    FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
);

insert into customers(customer_name, mobile, email, city) values('Ravi Kumar', '9876543210', 'ravi@gmail.com', 'Hyderabad'),
('Priya Sharma', '9876543211', 'priya@gmail.com', 'Chennai'),
('Arjun Reddy', '9876543212', 'arjun@gmail.com', 'Bengaluru'),
('Sneha Patil', '9876543213', 'sneha@gmail.com', 'Pune'),
('Vikram Singh', '9876543214', 'vikram@gmail.com', 'Delhi');

insert into accounts (account_no, account_type, balance, customer_id) values('SB100001', 'Savings', 75000.00, 1),
('CA100002', 'Current', 125000.00, 2),
('SB100003', 'Savings', 50000.00, 3),
('SB100004', 'Savings', 90000.00, 4),
('CA100005', 'Current', 150000.00, 5);

select * from accounts where account_type = 'savings';
select * from accounts where balance >= 50000 AND account_type = 'current';

update accounts set balance = balance + 5000 where account_id = 1;
update customers set city = 'Mumbai' where customer_id = 4;

select * from customers;
select * from accounts;

DELETE FROM accounts WHERE account_id = 5; -- account is deleted but customer still exists 
delete from customers where customer_id = 1; -- will not delete because foreign key constraint