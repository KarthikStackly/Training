-- BANKING SCENARIO – QUESTIONS
-- Basic + WHERE + Operators (1–15)
-- 1.	Retrieve all accounts with balance greater than 20,000. 
-- select customers.customer_id, name, account_id, balance from accounts JOIN customers ON accounts.customer_id = customers.customer_id where balance > 20000; -- had to mention tableName.columnName to retrieve the very column on which the JOIN was performed
select * from accounts where balance > 20000;
-- 2.	Find customers who live in Chennai. 
select name, city from customers;
-- 3.	Display accounts with balance between 20,000 and 50,000.
-- select  customers.customer_id, name, account_id, balance from accounts JOIN customers ON accounts.customer_id = customers.customer_id where balance BETWEEN 20000 AND 50000;
select * from accounts where balance BETWEEN 20000 AND 50000;
-- 4.	Find customers whose names start with 'J'.
select * from customers where name LIKE 'J%'; 
-- 5.	Retrieve accounts of type 'Savings' or 'Current'. 
-- select customers.customer_id, name, account_type from accounts JOIN customers ON accounts.customer_id = customers.customer_id where account_type IN ("Savings", "Current");
select * from accounts where account_type IN ("Savings", "Current");
-- 6.	Display accounts that are not 'Savings'. 
select * from accounts where account_type != 'Savings';
-- 7.	Find customers whose names contain the letter 'a'.
select * from customers where name LIKE '%a%'; 
-- 8.	Retrieve accounts with balance less than or equal to 30,000.
select * from accounts where balance <= 30000; 
-- 9.	Find customers who are not from Madurai.
select * from customers where city != "Madurai"; 
-- 10.	Display accounts where balance is not between 10,000 and 40,000.
select * from accounts where balance NOT BETWEEN 10000 AND 40000;
-- OR
select * from accounts where balance < 10000 OR balance > 40000;
-- 11.	Retrieve customers whose names end with 'i'.
select * from customers where name Like "%i"; 
-- 12.	Find accounts with balance equal to 50,000.
select * from accounts where balance = 50000; 
-- 13.	Display customers whose city is either Chennai or Salem. 
select * from customers where city != "Chennai" AND city != "Salem";
-- OR
select * from customers where city NOT IN ("Chennai", "Salem");
-- 14.	Find accounts with balance greater than 10,000 and less than 40,000.
-- select * from accounts where balance BETWEEN 10000 AND 40000; -- this actually includes both so not preferred in this context...
-- OR
select * from accounts where balance > 10000 AND balance < 40000; 
-- 15.	Retrieve accounts where account type is not in ('Current'). 
select * from accounts where account_type != "Current";
-- ORDER BY (16–18)
-- 16.	Display all accounts sorted by balance in descending order. 
select * from accounts ORDER BY balance DESC;
-- 17.	List customers sorted alphabetically by name.
select * from customers ORDER BY name ASC; 
-- 18.	Display accounts sorted by account type and then by balance (descending). 
select * from accounts ORDER BY account_type, balance DESC;
--  Aggregate Functions (19–23)
-- 19.	Find the total balance of all accounts. 
select SUM(balance) AS Total_Balance from accounts;
-- 20.	Calculate the average balance of accounts. 
select AVG(balance) from accounts;
-- 21.	Find the maximum account balance.
SELECT MAX(balance) from accounts; 
-- 22.	Find the minimum account balance.
select MIN(balance) from accounts; 
-- 23.	Count the total number of customers. 
select Count(*) from customers;
--  GROUP BY + HAVING (24–28)
-- 24.	Find total balance grouped by account type.
select SUM(balance) AS Total_Balance, account_type from accounts GROUP BY account_type; 
-- 25.	Find average balance for each account type. 
select AVG(balance) AS Average_Balance, account_type from accounts GROUP BY account_type;
-- 26.	Display account types having average balance greater than 20,000. 
select account_type from accounts GROUP BY account_type HAVING AVG(balance) > 20000;
-- 27.	Count number of accounts for each customer. 
select customer_id, COUNT(account_id) AS Number_Of_Accounts from accounts GROUP BY customer_id;
-- 28.	Display customers having more than one account.
select name, COUNT(accounts.customer_id) AS Number_Of_Accounts from customers JOIN accounts ON customers.customer_id = accounts.customer_id GROUP BY customers.customer_id HAVING COUNT(accounts.customer_id) > 1; 
--  JOINS (29–35)
-- 29.	Retrieve customer names along with their account balances. 
select name, balance from customers JOIN accounts ON accounts.customer_id = customers.customer_id;
-- 30.	Display all customers and their accounts (including customers without accounts). 
select name, account_type, account_id from customers JOIN accounts ON accounts.customer_id = customers.customer_id;
-- 31.	Display all accounts and corresponding customer details. 
select * from accounts JOIN customers ON customers.customer_id = accounts.customer_id GROUP BY account_id;
-- 32.	Retrieve customer names and account types where balance is greater than 20,000. 
select name, account_type from customers JOIN accounts ON customers.customer_id = accounts.customer_id WHERE balance > 20000;
-- 33.	List customers with their total balance using JOIN. 
select name, SUM(balance) AS Total_Balace from customers JOIN accounts ON customers.customer_id = accounts.customer_id GROUP BY accounts.customer_id; -- grouping by customer id is what sums it up. Alternatively name could be used but best to use a primary key column 
-- 34.	Display customer names and balances sorted by balance. 
select name, balance from customers JOIN accounts ON customers.customer_id = accounts.account_id ORDER BY balance; 
-- 35.	Count number of accounts for each city using JOIN. 
select city, COUNT(account_id) AS Number_Of_Accounts from customers JOIN accounts ON customers.customer_id = accounts.account_id GROUP BY city; 
--  SUBQUERIES (36–40)
-- 36.	Find accounts with balance greater than average balance. 
select * from accounts where balance > (select AVG(balance) from accounts);
-- 37.	Retrieve customers who have accounts. 
select * from customers where customer_id IN (select customer_id from accounts);
-- OR
select * from customers where EXISTS (select customer_id from accounts); -- doubtful because all customers have accounts in my example. 
-- 38.	Find customers who do not have any accounts. 
select * from customers where customer_id NOT IN (select customer_id from accounts);
-- OR
select * from customers WHERE NOT EXISTS (select customer_id from accounts); -- doubtful
-- 39.	Display account(s) with the maximum balance. 
select * from accounts where balance = (select MAX(balance) from accounts);
-- 40.	Find customers whose total balance is greater than 40,000. 
select customer_id, name, Total_Balance from (select customers.customer_id, name, SUM(balance) AS Total_Balance from accounts JOIN customers ON accounts.customer_id = customers.customer_id GROUP BY customer_id) AS Totals where Total_Balance > 40000; -- ...Trickiest
-- I can't use customers.customer_id in the outer query but can invoke Total_Balance even before calculating it? Research...