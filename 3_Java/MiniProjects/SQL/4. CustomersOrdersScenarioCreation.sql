create table Customer(
    customer_id int PRIMARY KEY,
    customer_name VARCHAR(50),
    city VARCHAR(30)
);

create table Orders(
    order_id int PRIMARY KEY,
    customer_id int,
    amount DECIMAL(10,2),
    order_date DATE,

    FOREIGN KEY(customer_id) REFERENCES Customer(customer_id)
);

show tables;

-- insert into Customers_Orders VALUES ();
INSERT INTO Customer (customer_id, customer_name, city) VALUES
(1, 'Aarav Sharma', 'Mumbai'),
(2, 'Priya Patel', 'Delhi'),
(3, 'Rohan Verma', 'Bengaluru'),
(4, 'Ananya Iyer', 'Chennai'),
(5, 'Vikram Singh', 'Hyderabad'),
(6, 'Sneha Gupta', 'Kolkata');

-- Insert into Orders
INSERT INTO Orders (order_id, customer_id, amount, order_date) VALUES
-- Aarav Sharma (4 orders, Total: 13,000.00)
(101, 1, 3500.00, '2026-01-10'),
(102, 1, 4000.00, '2026-01-15'),
(103, 1, 3000.00, '2026-02-01'),
(104, 1, 2500.00, '2026-02-10'),

-- Priya Patel (2 orders, Total: 6,500.00)
(105, 2, 3000.00, '2026-01-12'),
(106, 2, 3500.00, '2026-01-20'),

-- Rohan Verma (1 order, Total: 12,000.00)
(107, 3, 12000.00, '2026-01-14'),

-- Ananya Iyer (3 orders, Total: 2,000.00)
(108, 4, 500.00, '2026-01-05'),
(109, 4, 800.00, '2026-01-18'),
(110, 4, 700.00, '2026-02-05'),

-- Vikram Singh (3 orders, Total: 9,000.00)
(111, 5, 3000.00, '2026-01-22'),
(112, 5, 3000.00, '2026-02-03'),
(113, 5, 3000.00, '2026-02-15'),

-- Sneha Gupta (1 order, Total: 1,500.00)
(114, 6, 1500.00, '2026-01-25');

select * from Customer C JOIN Orders O ON C.customer_id = O.customer_id;