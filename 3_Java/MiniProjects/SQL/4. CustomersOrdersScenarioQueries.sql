-- Customers & Orders Tables
-- 16.	Find the total order amount for each customer. 
select customer_name, SUM(amount) AS Total_Order_Amount from Orders JOIN Customer on Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY customer_name ASC; -- Grouped by primary key because unique, and ordered by name because readable...
-- 17.	Find customers who have placed more than 3 orders.
select customer_name, COUNT(Orders.customer_id) AS Total_Orders from Orders JOIN Customer on Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING SUM(Orders.customer_id) > 3;
-- 18.	Find the average order amount for each customer.
select customer_name, AVG(amount) AS Average_Order_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY AVG(amount) DESC; 
-- 19.	Find the highest order amount placed by each customer. 
select customer_name, MAX(amount) AS Highest_Order_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDEr BY Highest_Order_amount DESC;
-- 20.	Display customers sorted by their total purchase amount. 
select customer_name, SUM(amount) AS Total_Purchase_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY Total_Purchase_Amount ASC;
-- 21.	Find customers whose total purchase amount exceeds 10,000. 
select customer_name, SUM(amount) AS Total_Purchase from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING Total_Purchase > 10000 ORDER BY Total_Purchase DESC;
-- 22.	Display customer names along with the total number of orders placed. 
select customer_name, COUNt(order_id) AS Total_Orders_Placed from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDEr BY TOtal_Orders_Placed DESC;

-- 23.	Find the customer who spent the highest amount. 
-- select MAX(Total_Spend_Per_Customer) AS Highest_Total_Spent From (select SUM(amount) AS Total_Spend_Per_Customer from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id) AS Customer_TOtal; -- If only MAX(SUM) worked...
select Customer.customer_name, SUM(Orders.amount) AS Total_Spent 
from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING SUM(Orders.amount) = ( -- And here I am matching that to find the customer
    select MAX(Total_Spend_Per_Customer) from -- Selecting Max out of that
        (select SUM(amount) AS Total_Spend_Per_Customer from Orders GROUP BY customer_id) AS Some_Name); -- this gives me Totals Amounts per customer
-- OR
select customer_name, Max(amount) AS Highest_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING MAX(amount) ORDER BY Highest_Amount DESC LIMIT 1; -- Highest Amount Paid overall

-- 24.	Find the customer who placed the maximum number of orders. 
select customer_name, Count(order_id) AS Total_Orders -- retrieving names
from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING Count(Orders.order_id) = -- matching case by joining tables
    (select MAX(Count_Of_Orders) AS Max_Orders from -- finding max
        (select COUNT(customer_id) AS Count_Of_Orders from Orders GROUP BY customer_id) AS Some_Name); -- counting totals

-- 25.	Find customers whose average order amount is greater than 2,000. 
select customer_name, AVG(amount) AS Average_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING Average_Amount > 2000;
-- 26.	Display the top 5 customers based on total purchase amount. 
select customer_name, SUM(amount) AS Total_Purchase_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY Total_Purchase_Amount DESC LIMIT 5;
-- 27.	Find the minimum order amount for each customer. 
select customer_name, MIN(amount) from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY customer_name ASC;
-- 28.	Find customers who have placed orders worth more than 5,000 in total. 
select customer_name, SUM(amount) AS Total_Spent from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING Total_Spent > 5000 ORDER BY Total_Spent ASC;
-- 29.	Display customer-wise total orders and total purchase amount. 
select customer_name, COUNT(Orders.customer_id) AS Total_Orders, SUM(amount) AS Total_Purchase_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id ORDER BY Total_Orders ASC;
-- 30.	Find customers who placed more than 2 orders and spent more than 8,000. 
select customer_name, COUNT(Orders.customer_id) AS Total_Orders, SUM(amount) AS Total_Purchase_Amount from Customer JOIN Orders ON Customer.customer_id = Orders.customer_id GROUP BY Customer.customer_id HAVING Total_Orders > 2 AND Total_Purchase_Amount > 8000 ORDER BY Total_Orders ASC;