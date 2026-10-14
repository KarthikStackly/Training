show DATABASES;
create DATABASE prac1_aadhaar;
use prac1_aadhaar;

create TABLE addresses (
    address_id int PRIMARY KEY AUTO_INCREMENT,
    house_no varchar(20) NOT NULL,
    street varchar(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT null,
    pincode VARCHAR(6) not null
);

select * from addresses;

insert into addresses(house_no, street, city, state, pincode) 
values ('12-4-25', 'MG Road', 'Hyderabad', 'Telangana', '500001'),
('24-7-18', 'Anna Nagar', 'Chennai', 'Tamil Nadu', '600040'),
('45/2', 'Indiranagar', 'Bengaluru', 'Karnataka', '560038'),
('18-9-12', 'Kothrud Road', 'Pune', 'Maharashtra', '411038'),
('7-5-10', 'Salt Lake Road', 'Kolkata', 'West Bengal', '700091');

create table citizens (
    citizen_id int PRIMARY KEY AUTO_INCREMENT,
    citizen_name varchar(100) not null,
    dob DATE not null,
    gender varchar(10) not null CHECK(gender IN('Male', 'Female', 'Other')),
    mobile VARCHAR(10) unique,
    address_id int NOT NULL,

    CONSTRAINT fk_citizen_address
        FOREIGN KEY(address_id)
        REFERENCES addresses(address_id)
);

select * from citizens;

insert into citizens (citizen_name, dob, gender, mobile, address_id) values('Ravi Kumar', '1998-05-12', 'Male', '9876543210', 1),
('Priya Sharma', '2000-08-21', 'Female', '9876543211', 2),
('Arjun Reddy', '1995-02-15', 'Male', '9876543212', 3),
('Sneha Patil', '1999-11-03', 'Female', '9876543213', 4),
('Amit Das', '1997-06-28', 'Male', '9876543214', 5);

update citizens set mobile = '9123456780' where citizen_id = 1;

update citizens set address_id = 4 where citizen_id = 2; -- two people same address scenario...

DELETE from citizens where citizen_id = 5;

alter table citizens add email varchar(50) unique;
update citizens set email = 'ravi@gmail.com' where citizen_id = 4;
alter table citizens modify email varchar(60);
alter table citizens rename column email to email_address;
-- alter table citizens drop column email_address;