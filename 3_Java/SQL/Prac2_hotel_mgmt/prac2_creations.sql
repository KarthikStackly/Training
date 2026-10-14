show DATABASES;
create DATABASE HotelPrac;
use HotelPrac;
create TABLE Hotels(
    hotel_id int primary key AUTO_INCREMENT,
    hotel_name varchar(50),
    city VARCHAR(30),
    star_rating int
);

insert into Hotels (hotel_name, city, star_rating) values ('Grand Palace', 'Chennai', 5), ('Royal Inn', 'Bamgalore', 4), ('Blue Moon', 'Hyderabad', 3);

create table Rooms(
room_id int primary key AUTO_INCREMENT,
hotel_id int,
room_number VARCHAR(10),
room_type VARCHAR(20),
price DECIMAL(10,2),
status VARCHAR(20),

FOREIGN KEY(hotel_id) references Hotels(hotel_id)
);

insert into Rooms (hotel_id, room_number, room_type, price, status) values(1,'101','Standard',2500,'Available'),
(1,'102','Deluxe',4000,'Occupied'),
(1,'103','Suite',7000,'Occupied'),
(2,'201','Standard',2200,'Available'),
(2,'202','Deluxe',3800,'Occupied'),
(3,'301','Standard',1800,'Available'),
(3,'302','Suite',6000,'Occupied');

create table Guests(
    guest_id int primary key AUTO_INCREMENT,
    guest_name VARCHAR(50),
    phone VARCHAR(15),
    city VARCHAR(30)
);

insert into Guests (guest_name, phone, city) values('Rahul','9876543210','Chennai'),
('Priya','9876543211','Bangalore'),
('Arun','9876543212','Hyderabad'),
('Sneha','9876543213','Coimbatore'),
('Karthik','9876543214','Mumbai');


create table bookings(
    booking_id int PRIMARY KEY AUTO_INCREMENT,
    guest_id int,
    room_id int,
    check_in DATE,
    check_out DATE,
    booking_status VARCHAR(20), 

    FOREIGN KEY(guest_id) REFERENCES Guests(guest_id),
    FOREIGN KEY(room_id) REFERENCES Rooms (room_id)
);

insert into bookings (guest_id, room_id, check_in, check_out, booking_status) values (1,2,'2026-07-25','2026-07-30','Completed'),
(2,3,'2026-07-28','2026-08-02','Active'),
(3,5,'2026-07-29','2026-08-01','Active'),
(4,7,'2026-07-20','2026-07-22','Completed'),
(1,1,'2026-08-05','2026-08-08','Booked'),
(5,4,'2026-07-31','2026-08-03','Cancelled');

create table payments(
    payment_id int PRIMARY KEY AUTO_INCREMENT,
    booking_id int,
    amount DECIMAL(10,2),
    payment_status VARCHAR(20),

    FOREIGN KEY(booking_id) REFERENCES Bookings(booking_id)
);

insert into payments (booking_id, amount, payment_status) values (1,20000,'Paid'),
(2,35000,'Paid'),
(3,12000,'Pending'),
(4,15000,'Paid'),
(5,7500,'Pending'),
(6,0,'Refunded');

update Bookings set check_in = '2026-10-09', check_out = '2026-10-12' WHERE booking_id = 2;
update Bookings set check_in = '2026-10-09', check_out = '2026-10-11' WHERE booking_id = 6;
update Bookings set check_in = '2026-10-08', check_out = '2026-10-10' WHERE booking_id = 3;

SELECT * from payments;
SELECT * from bookings;
SELECT * from guests;
SELECT * from rooms;
select * from hotels;