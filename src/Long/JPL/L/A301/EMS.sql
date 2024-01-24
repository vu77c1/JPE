-- Create the SMS database
CREATE
DATABASE SMS;
GO

-- Use the SMS database
USE SMS;
GO

-- Create the Customer table
CREATE TABLE dbo.Customer
(
    customer_id   INT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL
);
GO

-- Create the Employee table
CREATE TABLE dbo.Employee
(
    employee_id   INT PRIMARY KEY,
    employee_name VARCHAR(255)   NOT NULL,
    salary        DECIMAL(10, 2) NOT NULL,
    supervisor_id INT,
    FOREIGN KEY (supervisor_id) REFERENCES dbo.Employee (employee_id)
);
GO

-- Create the Product table
CREATE TABLE dbo.Product
(
    product_id   INT PRIMARY KEY,
    product_name VARCHAR(255)   NOT NULL,
    list_price   DECIMAL(10, 2) NOT NULL
);
GO

-- Create the Orders table
CREATE TABLE dbo.Orders
(
    order_id    INT PRIMARY KEY,
    order_date  DATE NOT NULL,
    customer_id INT,
    employee_id INT,
    total       DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES dbo.Customer (customer_id),
    FOREIGN KEY (employee_id) REFERENCES dbo.Employee (employee_id)
);
GO

-- Create the LineItem table
CREATE TABLE dbo.LineItem
(
    order_id   INT,
    product_id INT,
    quantity   INT,
    price      DECIMAL(10, 2),
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES dbo.Orders (order_id),
    FOREIGN KEY (product_id) REFERENCES dbo.Product (product_id)
);
GO

-- Dữ liệu mẫu cho bảng Customer
INSERT INTO dbo.Customer (customer_id, customer_name)
VALUES
    (1, 'Nguyễn Văn A'),
    (2, 'Trần Thị Bình'),
    (3, 'Lê Hoàng C'),
    (4, 'Phạm Thị Dương'),
    (5, 'Hoàng Minh Đức'),
    (6, 'Nguyễn Thị Hương'),
    (7, 'Đặng Văn Khoa'),
    (8, 'Nguyễn Thị Mai'),
    (9, 'Lê Anh Minh'),
    (10, 'Vũ Thị Ngọc');

-- Dữ liệu mẫu cho bảng Employee
INSERT INTO dbo.Employee (employee_id, employee_name, salary, supervisor_id)
VALUES (1, 'Nguyễn Văn Nam', 60000.00, NULL),
       (2, 'Trần Thị Ngọc Anh', 55000.00, 1),
       (3, 'Lê Minh Tiến', 58000.00, 1),
       (4, 'Phạm Thị Hà', 62000.00, 1),
       (5, 'Hoàng Văn Hùng', 65000.00, 2),
       (6, 'Nguyễn Thị Hương Lan', 70000.00, 3),
       (7, 'Đặng Văn Tùng', 52000.00, 3),
       (8, 'Nguyễn Thị Mai Linh', 59000.00, 3),
       (9, 'Lê Văn Quang', 54000.00, 2),
       (10, 'Vũ Thị Lan Anh', 58000.00, 1);

-- Dữ liệu mẫu cho bảng Product
INSERT INTO dbo.Product (product_id, product_name, list_price)
VALUES (1, 'Laptop X', 1200.00),
       (2, 'Smartphone Y', 800.00),
       (3, 'Wireless Headphones Z', 150.00),
       (4, 'Smartwatch A', 200.00),
       (5, '4K Ultra HD TV B', 1000.00),
       (6, 'Gaming Console C', 500.00),
       (7, 'High-Performance Graphics Card D', 300.00),
       (8, 'Home Automation System E', 600.00),
       (9, 'Augmented Reality Glasses F', 800.00),
       (10, 'Drones with HD Camera G', 250.00);

-- Dữ liệu mẫu cho bảng Orders
INSERT INTO dbo.Orders (order_id, order_date, customer_id, employee_id, total)
VALUES (1, '2024-01-01', 1, 1, 50.00),
       (2, '2024-01-02', 2, 2, 60.00),
       (3, '2024-01-03', 3, 3, 45.00),
       (4, '2024-01-04', 4, 4, 80.00),
       (5, '2024-01-05', 5, 5, 25.00),
       (6, '2024-01-06', 6, 6, 70.00),
       (7, '2024-01-07', 7, 7, 56.00),
       (8, '2024-01-08', 8, 8, 44.00),
       (9, '2024-01-09', 9, 9, 36.00),
       (10, '2024-01-10', 10, 10, 64.00);

-- Dữ liệu mẫu cho bảng LineItem
INSERT INTO dbo.LineItem (order_id, product_id, quantity, price)
VALUES (1, 1, 2, 40.00),
       (1, 2, 1, 10.00),
       (2, 3, 3, 75.00),
       (2, 5, 2, 30.00),
       (3, 1, 1, 20.00),
       (3, 3, 2, 50.00),
       (4, 4, 4, 160.00),
       (5, 5, 1, 15.00),
       (6, 6, 3, 105.00),
       (7, 7, 2, 56.00);



CREATE PROCEDURE usp_addCustomer @customerName VARCHAR(255),
    @customerId INT
AS
BEGIN
INSERT INTO dbo.Customer (customer_id, customer_name)
VALUES (@customerId, @customerName);
END;
 exec usp_addCustomer 'haha',100


    CREATE PROCEDURE usp_deleteCustomerWithOrders
        @customerId INT,
        @success BIT OUTPUT
    AS
    BEGIN
        SET @success = 0; -- Initialize to failure

        BEGIN TRY
            -- Use a transaction to ensure atomicity
            BEGIN TRANSACTION;

            -- First, delete OrderedProducts related to orders of the customer
            DELETE FROM dbo.LineItem
            WHERE order_id IN (SELECT order_id FROM dbo.Orders WHERE customer_id = @customerId);

            -- Next, delete Orders of the customer
            DELETE FROM dbo.Orders
            WHERE customer_id = @customerId;

            -- Finally, delete the customer
            DELETE FROM dbo.Customer
            WHERE customer_id = @customerId;

            -- Commit the transaction if all deletes succeed
            COMMIT;

            SET @success = 1; -- Set to success

        END TRY
        BEGIN CATCH
            -- Rollback the transaction if any error occurs
            ROLLBACK;

            SET @success = 0; -- Set to failure
        END CATCH;
    END;

