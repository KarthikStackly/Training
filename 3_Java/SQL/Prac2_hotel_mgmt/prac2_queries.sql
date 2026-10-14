show TABLES;
-- 1. Display all rooms available for booking...
-- select * from Rooms JOIN Hotels ON Rooms.hotel_id = Hotels.hotel_id WHERE status = 'available'; -- ON is where we write the connection between the two tables. WHERE is the retrieval condition to check. 
select room_number, room_type, price, hotel_name from Rooms JOIN Hotels ON rooms.hotel_id = hotels.hotel_id WHERE status = 'available';

-- 2. Display guests currently staying in the hotel. Today should be between check in and check out. 
select guest_name, hotel_name, room_number, check_in, check_out from Guests JOIN Bookings ON Guests.guest_id = Bookings.guest_id  JOIN Rooms ON Bookings.room_id = Rooms.room_id JOIN Hotels ON Rooms.hotel_id = Hotels.hotel_id WHERE CURDATE() BETWEEN check_in AND check_out AND booking_status = 'Active';

-- 3. Find total money recieved from paid bookings
select SUM(amount) AS Total_Revenue from payments where payment_status = 'paid';

-- 4. Display bookings between 2 dates;
-- select * from Bookings WHERE check_in BETWEEN '2026-07-25' AND '2026-07-31' ;
select booking_id, guest_name, hotel_name, check_in, check_out from Bookings JOIN Guests ON Bookings.guest_id = Guests.guest_id JOIN Rooms ON Rooms.room_id = Bookings.room_id JOIN Hotels ON rooms.hotel_id = Hotels.hotel_id WHERE check_in BETWEEN '2026-07-25' AND '2026-07-31';
-- Since we need hotel_name, which isn't connected in Bookings db at all, we first retrieve hotel_id from Rooms by Joining, THEN retrieve hotel_name using this hotel_id by joining Hotels... Rest all were just Booking & Guests dbs. But only for hotel_name, we had to join two more tables to Bookings. Finding connections...

-- 5. Most booked room type
select room_type, COUNT(*) AS Total_Bookings from Bookings JOIN Rooms ON Bookings.room_id = Rooms.room_id GROUP BY room_type ORDEr BY Total_Bookings DESC; -- LIMIT 1;
select room_type, COUNT(*) AS Total_Bookings from Bookings JOIN Rooms ON Bookings.room_id = Rooms.room_id WHERE booking_status = 'completed' GROUP BY room_type ORDEr BY Total_Bookings DESC;
select room_type, COUNT(*) AS Total_Bookings from Bookings JOIN Rooms ON Bookings.room_id = Rooms.room_id WHERE status = 'occupied' GROUP BY room_type ORDEr BY Total_Bookings DESC;

-- 6. Calc occupancy rate
select ROUND(Count(CASE When status = 'Occupied' THEN 1 END) * 100.0 / COUNT(*), 4) AS Occupancy_Rate from Rooms;

-- 7. Display cancelled bookings
-- select * from Bookings WHERE booking_status = 'cancelled';
select booking_id, guest_name, hotel_name, room_number from Bookings JOIN Guests ON Bookings.guest_id = Guests.guest_id JOIN Rooms ON Bookings.room_id = Rooms.room_id JOIN Hotels ON Rooms.hotel_id = Hotels.hotel_id WHERE booking_status = 'cancelled';

-- 8. Find customers with multiple bookings
-- select * from Bookings WHERE COUNT(guest_id) > 1;
select guest_name, COUNT(booking_id) AS Total_Bookings from Guests JOIN Bookings ON Guests.guest_id = Bookings.guest_id GROUP BY guest_name HAVING COUNT(*) > 1;
-- Since we don't have Multiple bookings under the same id, we have to expand the search to Guests table and Then count by name, or all?

