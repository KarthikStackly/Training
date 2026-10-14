show databases;
use mini_project_1;
show tables;

create table Trains(
    train_id int primary key AUTO_INCREMENT,
    train_name VARCHAR(50),
    source VARCHAR(50),
    destination VARCHAR(50)
);

create table Bookings(
    booking_id int primary key AUTO_INCREMENT,
    train_id int, 
    passenger_name varchar(50),
    fare DECIMAL(10,2),
    status VARCHAR(20),

    FOREIGN KEY (train_id) REFERENCES Trains(train_id)
);

show tables; -- uh OH!

insert into trains(train_name, source, destination) values('Express1','Chennai','Madurai'),
('Express2','Coimbatore','Salem'),
('Express3','Madurai','Chennai');

insert into bookings(train_id, passenger_name, fare, status) values(1,'Janani',500,'Confirmed'),
(1,'Arun',500,'Waiting'),
(2,'Priya',300,'Confirmed'),
(3,'Karthik',450,'Cancelled'),
(2,'Meena',300,'Confirmed');

select * from trains JOIN bookings ON trains.train_id = bookings.train_id;