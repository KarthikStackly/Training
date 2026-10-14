-- RAILWAY RESERVATION – QUESTIONS
-- Basic + WHERE + Operators (41–45)
-- 41.	Retrieve all bookings with fare greater than 400. 
select * from bookings where fare > 400;
-- 42.	Find bookings where status is not 'Confirmed'.
select * from bookings where status != 'Confirmed'; 
-- 43.	Display trains starting from Chennai.
select * from trains where source = "Chennai"; 
-- 44.	Retrieve bookings with fare between 300 and 500.
select * from bookings where fare BETWEEN 300 AND 500; 
-- 45.	Find passengers whose names start with 'A'. 
select * from bookings where passenger_name LIKE "A%";
--  JOINS + GROUP BY + ORDER BY (46–48)
-- 46.	Retrieve train names along with passenger names.
select train_name, passenger_name from trains JOIN bookings ON trains.train_id = bookings.train_id; 
-- 47.	Count number of bookings for each train.
select train_name, COUNT(*) AS Number_Of_Bookings from bookings JOIN trains on trains.train_id = bookings.train_id GROUP BY train_name ORDER BY train_name ASC; -- Order By not necessary but added anyway...
-- 48.	Display train names and total fare collected for each train.
select train_name, SUM(fare) AS Total_Fare_Collected from trains JOIN bookings ON trains.train_id = bookings.train_id GROUP BY train_name ORDER BY train_name ASC; -- Order by might be necessary if there were more data it'd be clear. 
--  SUBQUERIES (49–50)
-- 49.	Find bookings with fare equal to the highest fare
select * from bookings where fare = (Select MAX(fare) from bookings); 
-- 50.	Retrieve trains that have more than one booking. 
select * from trains where train_id IN (select train_id from bookings GROUP BY train_id HAVING COUNT(train_id) > 1);