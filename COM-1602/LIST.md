
## 04-12-66

##### `billorder.sql`<br>
Create: 6 ธ.ค. 2566 เวลา 16:35<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Create Billorder Table
CREATE TABLE Billorder_461 (IdBillorder VARCHAR(10) PRIMARY KEY, Id_Sup VARCHAR(10)) ENGINE = MYISAM;

-- Add Billorder Data
INSERT INTO
	Billorder_461 (IdBillorder, Id_Sup)
VALUES
	('BC001', 'SP001'),
	('BC002', 'SP002'),
	('BC003', 'SP003'),
	('BC004', 'SP004');

-- Show Billorder data
SELECT
	*
FROM
	Billorder_461;

```

##### `detail_order.sql`<br>
Create: 6 ธ.ค. 2566 เวลา 16:35<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Create DetailOrder Table
CREATE TABLE DetailOrder_461 (IdBillorder CHAR(5), IdProduct CHAR(4), Amount INT(8)) ENGINE = MYISAM;

-- Add DetailOrder Data
INSERT INTO
	DetailOrder_461 (IdBillorder, IdProduct, Amount)
VALUES
	('BC001', 'P01', 100),
	('BC001', 'P02', 200),
	('BC001', 'P03', 100),
	('BC001', 'P03', 100),
	('BC002', 'P02', 300),
	('BC002', 'P03', 300),
	('BC003', 'P03', 50),
	('BC003', 'B02', 100),
	('BC004', 'L01', 20);

-- Show DetailOrder data
SELECT
	*
FROM
	DetailOrder_461;

```

##### `product.sql`<br>
Create: 6 ธ.ค. 2566 เวลา 16:35<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Create Product Table
CREATE TABLE Product_461 (IdProduct CHAR(3) PRIMARY KEY, NameProduct VARCHAR(20), Price INT(4)) ENGINE = MYISAM;

-- Add Product Data 
INSERT INTO
	Product_461 (IdProduct, NameProduct, Price)
VALUES
	('P01', 'Paper A4 70 g.', 105),
	('P02', 'Paper A4 80 g.', 120),
	('P03', 'Paper F4 80 g.', 130),
	('P04', 'Paper B2 80 g.', 150),
	('B01', 'Blue Pen', 25),
	('B02', 'Red Pen', 15),
	('L01', 'Toner printer', 5500);

-- Show product data 
SELECT
	*
FROM
	Product_461;

```


## 05-02-67

##### `product.sql`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
CREATE TABLE products (product_code VARCHAR(10), product_type VARCHAR(50), price_per_unit DECIMAL(10, 2));

INSERT INTO
	products (product_code, product_type, price_per_unit)
VALUES
	('C01', 'Water Color', 50),
	('C02', 'Color Pencils', 120);

```

##### `product_app.sql`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
CREATE TABLE products (product_code VARCHAR(10), product_type VARCHAR(50), price_per_unit DECIMAL(10, 2));

INSERT INTO
	products (product_code, product_type, price_per_unit)
VALUES
	('C01', 'Water Color Art', 250),
	('C02', 'Color Pencils', 120),
	('C03', 'Black Color Art', 70),
	('C04', 'Blue Color', 40),
	('C05', 'Black Color', 50);

```

##### `update-delete.sql`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
```sql

```


## 05-02-67-php

##### `test.php`<br>
Create: 5 ก.พ. 2567 เวลา 16:00<br>
```php
<html>

<head>
   <style>
      table {
         font-family: arial, sans-serif;
         border-collapse: collapse;
         width: 50%;
      }

      td,
      th {
         border: 1px solid #dddddd;
         text-align: left;
         padding: 8px;
      }

      tr:nth-child(even) {
         background-color: #dddddd;
      }
   </style>
</head>

<body>
   <?php
   $connect = mysqli_connect("localhost", "root", "", "faelayis") or die("เกิดข้อผิดพลาดเกิดขึ้น");

   if ($connect) {
      echo " เชื่อมต่อฐานข้อมูลสำเร็จ <br>";
   }

   mysqli_set_charset($connect, 'utf8');

   $sql = "SELECT * FROM student461";
   $result = mysqli_query($connect, $sql);

   echo "<table>";
   echo '<tr>
   <th>รหัสนักศึกษา</th>
   <th>ชื่อ</th>
   <th>Major id</th>
   <th>Faculty id</th>
   </tr>';
   while ($db = mysqli_fetch_array($result)) {
      echo "<tr>";
      echo "<td>" . $db["Stu_id"] . "</td>";
      echo "<td>" . $db["Stu_name"] . "</td>";
      echo "<td>" . $db["Major_id"] . "</td>";
      echo "<td>" . $db["Faculty_id"] . "</td>";
      echo "</tr>";
   }
   echo "</table>";

   mysqli_close($connect);

```


## 20-11-66

##### `init.ps1`<br>
Create: 20 พ.ย. 2566 เวลา 15:58<br>
Update: 22 ม.ค. 2567 เวลา 15:09<br>
```ps1
Set-Location C:\xampp\mysql\bin
.\mysql.exe -u root -p

create database faelayis;
use faelayis

# Create Table
create table Supplier_461 (
   id_sup char(5) not null,
   name_sup varchar(20),
   address varchar(50),
   primary key (id_sup)
) engine = myisam;

# Insert Table
insert into Supplier_461 values('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
                       ('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
                       ('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
                       ('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
                       ('SP005', 'Parada Company', '102 T.Changphuak');

# Show Table Data
select * from Supplier_461;
```

##### `schema.sql`<br>
Create: 20 พ.ย. 2566 เวลา 16:25<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Create database
CREATE DATABASE faelayis;

-- Switch to the database
USE faelayis;

-- Create table
CREATE TABLE Supplier_461 (id_sup CHAR(5) NOT NULL, name_sup VARCHAR(20), address VARCHAR(50), PRIMARY KEY (id_sup)) ENGINE = MyISAM;

-- Insert data into the table
INSERT INTO
	Supplier_461
VALUES
	('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
	('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
	('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
	('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
	('SP005', 'Parada Company', '102 T.Changphuak');

-- Show table data
SELECT
	*
FROM
	Supplier_461;

```


## 22-01-67

##### `select.sql`<br>
Create: 22 ม.ค. 2567 เวลา 14:43<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- 1
SELECT
	*
FROM
	Supplier_461
WHERE
	address LIKE '%Changphuak%';

-- 2
SELECT
	*
FROM
	Product_461
WHERE
	NOT LIKE '%053%';

-- 3
SELECT
	*
FROM
	Product_461
WHERE
	NameProduct LIKE '%pen%';

-- 4
SELECT
	*
FROM
	Product_461
WHERE
	Price < 150
ORDER BY
	NameProduct DESC;

-- 5
SELECT DISTINCT
	IdProduct
FROM
	DetailOrder_461;

-- 6
SELECT
	*
FROM
	DetailOrder_461
WHERE
	Amount > 100;

-- 7
SELECT
	d.IdProduct,
	SUM(d.Amount) AS TotalAmount,
	p.Price,
	SUM(d.Amount * p.Price) AS TotalPrice
FROM
	DetailOrder_461 d
	JOIN Product_461 p ON d.IdProduct = p.IdProduct
GROUP BY
	d.IdProduct,
	p.Price;

-- 8
SELECT
	IdProduct,
	SUM(Amount) as Total
FROM
	DetailOrder_461
GROUP BY
	IdProduct
HAVING
	SUM(Amount);

-- 9
SELECT
	b.IdBillorder,
	b.id_sup,
	s.name_sup
FROM
	Billorder_461 AS b
	INNER JOIN Supplier_461 AS s ON b.id_sup = s.id_sup
ORDER BY
	s.name_sup;

-- 10
SELECT
	*
FROM
	Product_461
WHERE
	NameProduct LIKE '%80 g.%';

```


## 25-12-66

##### `data.sql`<br>
Create: 25 ธ.ค. 2566 เวลา 14:35<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Insert into Books
INSERT INTO
	Books (id, title, author, publisher, volume, call_number)
VALUES
	(1, 'ระบบฐานข้อมูล', 'ผศ.ดร.สมจิตร อาจอินทร์', 'ขอนแก่นการพิมพ์', 50, 'QA76.73.B33'),
	(2, 'เทคโนโลยีสารสนเทศเพื่อชีวิต', 'ภาควิชาคอมพิวเตอร์ ม.ราชภัฏเชียงใหม่', 'นุชติ้งพริ้นการพิมพ์', 40, 'QA76.74.B12'),
	(3, 'การวิเคราะห์และออกแบบระบบ', 'ดร.สมควร สมใจนึก', 'นุชติ้งพริ้นการพิมพ์', 60, 'QA76.75.B40');

-- Insert into BookCopies
INSERT INTO
	BookCopies (call_number, registration_number)
VALUES
	('QA76.73.B33', 'QA76.73.B33.C1'),
	('QA76.73.B33', 'QA76.73.B33.C2'),
	('QA76.73.B33', 'QA76.73.B33.C3');

-- Insert into TitlePrefix
INSERT INTO
	TitlePrefix (prefix_id, meaning)
VALUES
	(1, 'นาย'),
	(2, 'น.ส.'),
	(3, 'นาง');

-- Insert into Members
INSERT INTO
	Members (prefix_id, first_name, last_name, address, phone_number, id_card_number, member_id)
VALUES
	(2, 'ประภาพร', 'ใจคำ', '10 ถ.โชตนา ต.ช้างเผือก อ.เมือง จ.เชียงใหม่', '0807441777', '3100400258889', 18),
	(1, 'บัณฑิต', 'สุขสันต์', '145 หมู่ 3 ต.บ้านกลาง อ.เมือง จ.ลำพูน', '0652223398', '3544722358001', 2054),
	(1, 'ประสงค์', 'อยู่ดี', '54 หมู่ 5 ต.สันทรายน้อย อ.สันทราย จ.เชียงใหม่', '0895556666', '3144700133036', 7899),
	(3, 'สุมาลี', 'เปี่ยมล้น', '120 หมู่ 4 ต.แม่สา อ.แม่ริม จ.เชียงใหม่', '0637789994', '3577800145229', 10009);

-- Insert into BorrowReturn
INSERT INTO
	BorrowReturns (member_id, borrow_date, registration_number, due_date, return_date, fine_amount)
VALUES
	(18, '05/07/2566', 'QA76.73.B33.C3', '12/07/2566', '12/07/2566', 0),
	(18, '05/07/2566', 'QA76.74.B12.C1', '12/07/2566', '06/07/2566', 0),
	(2054, '05/07/2566', 'QA76.73.B33.C2', '12/07/2566', '11/07/2566', 0),
	(2054, '05/07/2566', 'QA76.75.B40.C1', '12/07/2566', '13/07/2566', 5),
	(7899, '20/07/2566', 'QA76.73.B33.C3', '27/07/2560', '27/07/2560', 0),
	(7899, '20/07/2566', 'QA76.75.B40.C1', '27/07/2560', '29/07/2560', 10);

-- Insert into FineRate
INSERT INTO
	FineRate (rate_id, book_limit, fine_rate)
VALUES
	('A1', 7, 5);

```

##### `schema.sql`<br>
Create: 25 ธ.ค. 2566 เวลา 14:35<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- Create database
CREATE DATABASE faelayis;

-- Switch to the database
USE faelayis;

CREATE TABLE Books (id INT PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), publisher VARCHAR(255), volume INT, call_number VARCHAR(255));

CREATE TABLE BookCopies (call_number VARCHAR(255), registration_number VARCHAR(255), FOREIGN KEY (call_number) REFERENCES Books (call_number));

CREATE TABLE TitlePrefix (prefix_id INT PRIMARY KEY, meaning VARCHAR(255));

CREATE TABLE Members (
	prefix_id INT,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	address VARCHAR(255),
	phone_number VARCHAR(15),
	id_card_number VARCHAR(13),
	member_id INT PRIMARY KEY,
	FOREIGN KEY (prefix_id) REFERENCES TitlePrefix (prefix_id)
);

CREATE TABLE BorrowReturn (
	member_id INT,
	borrow_date DATE,
	registration_number VARCHAR(255),
	due_date DATE,
	return_date DATE,
	fine_amount DECIMAL(5, 2),
	FOREIGN KEY (member_id) REFERENCES Members (member_id),
	FOREIGN KEY (registration_number) REFERENCES BookCopies (registration_number)
);

CREATE TABLE FineRate (rate_id VARCHAR(2) PRIMARY KEY, book_limit INT, fine_rate DECIMAL(5, 2));

```


## 27-11-66

##### `init.ps1`<br>
Create: 27 พ.ย. 2566 เวลา 16:55<br>
Update: 4 ธ.ค. 2566 เวลา 17:04<br>
```ps1
Set-Location C:\xampp\mysql\bin
.\mysql.exe -u root -p

use faelayis

alter table supplier461 modify name_sup varchar(30);

alter table supplier461 add tel int(9);

alter table supplier461 add zipcode int(6);

alter table supplier461 drop zipcode;

show create table supplier461;
```


## 29-01-67

##### `table.sql`<br>
Create: 29 ม.ค. 2567 เวลา 15:53<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- 1 แสดงรายละเอียดการสร้างตารางสินค้า (Product) ด้วยคำสั่ง Show Create Table
SHOW
CREATE TABLE Product_461;

-- 2 แก้ไขโครงสร้างตารางสินค้า (Product) โดยเปลี่ยน Field nameproduct  เป็น Varchar(35)
ALTER TABLE Product_461 MODIFY nameproduct VARCHAR(35);

-- 3 เพิ่ม Field  ชื่อ Num (จำนวนคงเหลือ) เป็นตัวเลขชนิด int ความกว้างเท่ากับ 4 ในตารางสินค้า (Product)
ALTER TABLE Product_461 ADD Num INT(4);

-- 4 เปลี่ยนชื่อ Field จาก Num เป็น  Numstock  ในตารางสินค้า (Product)
ALTER TABLE Product_461 CHANGE Num Numstock INT(4);

-- 5 แสดงโครงสร้างตารางสินค้า (Product) ด้วยคำสั่ง Describe
DESCRIBE Product_461;

-- 6 คัดลอกตารางทั้งหมดในตารางสินค้า (Product) ไปไว้ตารางใหม่ชื่อ ProductBAK
CREATE TABLE ProductBAK LIKE Product_461;

-- 7 คัดลอกตารางเฉพาะโครงสร้างตารางสินค้า (Product) ไปไว้ตารางใหม่ชื่อ ProductSTRU
CREATE TABLE ProductSTRU
SELECT
	*
FROM
	Product_461
WHERE
	1 = 0;

-- 8 คัดลอกตารางเฉพาะเรคคอร์ดที่มีราคาสินค้า (Price) มากกว่า 150 บาท ในตารางสินค้า (Product)   ไว้ตารางใหม่ชื่อ ProductCOPY1
CREATE TABLE ProductCOPY1
SELECT
	*
FROM
	Product_461
WHERE
	Price > 150;

-- 9 คัดลอกตารางเฉพาะเรคคอร์ดที่มีรหัสสินค้าขึ้นต้นด้วย P ในตารางสินค้า (Product)   ไว้ตารางใหม่ชื่อ ProductCOPY2
CREATE TABLE ProductCOPY2
SELECT
	*
FROM
	Product_461
WHERE
	idproduct LIKE 'P%';

-- 10 แสดงข้อมูลทั้งหมดในตาราง ProductCOPY1
SELECT
	*
FROM
	ProductCOPY1;

-- 11 แสดงโครงสร้างตาราง ProductCOPY1 ด้วยคำสั่ง Show Columns
SHOW COLUMNS
FROM
	ProductCOPY1;

-- 12 คัดลอกตารางทั้งหมดจากตาราง ProductCOPY1  เป็น ProductDEL
CREATE TABLE ProductDEL LIKE ProductCOPY1;

-- 13 เปลี่ยนชื่อตาราง ProductDEL เป็น ProductDROP
RENAME TABLE ProductDEL TO ProductDROP;

-- 14 ลบฟิลด์ NumStock ในตาราง ProductDROP
ALTER TABLE ProductDROP
DROP Numstock;

-- 15 ลบตารางชื่อ ProductDROP
DROP TABLE ProductDROP;

```


## Exam/1

##### `index.sql`<br>
Create: 12 ก.พ. 2567 เวลา 16:50<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- 4
ALTER TABLE product
RENAME TO product_461;

-- 5
ALTER TABLE sales
RENAME TO sales_461;

-- 6
LOAD data INFILE "Product.txt" INTO TABLE product_461;

-- 7
LOAD data INFILE "Sales.txt" INTO TABLE sales_461;

-- 8
SELECT
	*
FROM
	`product_461`;

SELECT
	*
FROM
	`sales_461`;

-- 9
DELETE FROM product_461
WHERE
	ProductID = 'ProductID';

-- 10
DELETE FROM sales_461
WHERE
	IDorder = 'Order';

-- 11
CREATE TABLE profit_461 AS
SELECT
	*,
	Quantity * UnitCost AS SalesCost,
	Quantity * UnitPrice AS SalesPrice,
	(Quantity * UnitPrice) - (Quantity * UnitCost) AS Profit
FROM
	sales_461;

-- 13
SELECT
	p.Category,
	SUM(x.Profit) AS sumprofit
FROM
	product_461 AS p
	INNER JOIN profit_461 AS x ON p.ProductID = x.ProductID
GROUP BY
	p.Category;

-- 14
SELECT
	ResellerID,
	SUM(profit) AS sumprofit
FROM
	profit_461
GROUP BY
	ResellerID;

-- 15
SELECT
	Category,
	COUNT(*) AS TotalProducts
FROM
	product_461
GROUP BY
	Category;

```

##### `order.sql`<br>
Create: 12 ก.พ. 2567 เวลา 17:22<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 12, 2024 at 11:14 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12
SET
	SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET
	time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;

/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `order_461`
--
-- --------------------------------------------------------
--
-- Table structure for table `product_461`
--
CREATE TABLE `product_461` (
	`ProductID` char(10) NOT NULL,
	`ProductName` varchar(35) NOT NULL,
	`Subcategory` varchar(30) NOT NULL,
	`Category` varchar(30) NOT NULL,
	`Color` varchar(15) NOT NULL,
	`Description` varchar(250) NOT NULL
) ENGINE = MyISAM DEFAULT CHARSET = utf8mb4;

--
-- Dumping data for table `product_461`
--
INSERT INTO
	`product_461` (`ProductID`, `ProductName`, `Subcategory`, `Category`, `Color`, `Description`)
VALUES
	('BB-7421', 'LL Bottom Bracket', 'Bottom Brackets', 'Components', 'NA', 'Chromoly steel.\r'),
	('BB-8107', 'ML Bottom Bracket', 'Bottom Brackets', 'Components', 'NA', 'Aluminum alloy cups; large diameter spindle.\r'),
	('BB-9108', 'HL Bottom Bracket', 'Bottom Brackets', 'Components', 'NA', 'Aluminum alloy cups and a hollow axle.\r'),
	('BC-M005', 'Mountain Bottle Cage', 'Bottles and Cages', 'Accessories', 'NA', 'Tough aluminum cage holds bottle securly on tough terrain.\r'),
	('BC-R205', 'Road Bottle Cage', 'Bottles and Cages', 'Accessories', 'NA', 'Aluminum cage is lighter than our mountain version; perfect for long distance trips.\r'),
	(
		'BK-M18B-40',
		'\"Mountain-500 Black, 40\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18B-42',
		'\"Mountain-500 Black, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18B-44',
		'\"Mountain-500 Black, 44\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18B-48',
		'\"Mountain-500 Black, 48\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18B-52',
		'\"Mountain-500 Black, 52\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18S-40',
		'\"Mountain-500 Silver, 40\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18S-42',
		'\"Mountain-500 Silver, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18S-44',
		'\"Mountain-500 Silver, 44\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18S-48',
		'\"Mountain-500 Silver, 48\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M18S-52',
		'\"Mountain-500 Silver, 52\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Suitable for any type of riding, on or off-road. Fits any budget. Smooth-shifting with a comfortable ride.\"\r'
	),
	(
		'BK-M38S-38',
		'\"Mountain-400-W Silver, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"This bike delivers a high-level of performance on a budget. It is responsive and maneuverable, and offers peace-of-mind when you decide to go off-road.\"\r'
	),
	(
		'BK-M38S-40',
		'\"Mountain-400-W Silver, 40\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"This bike delivers a high-level of performance on a budget. It is responsive and maneuverable, and offers peace-of-mind when you decide to go off-road.\"\r'
	),
	(
		'BK-M38S-42',
		'\"Mountain-400-W Silver, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"This bike delivers a high-level of performance on a budget. It is responsive and maneuverable, and offers peace-of-mind when you decide to go off-road.\"\r'
	),
	(
		'BK-M38S-46',
		'\"Mountain-400-W Silver, 46\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"This bike delivers a high-level of performance on a budget. It is responsive and maneuverable, and offers peace-of-mind when you decide to go off-road.\"\r'
	),
	(
		'BK-M47B-38',
		'\"Mountain-300 Black, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'For true trail addicts.  An extremely durable bike that will go anywhere and keep you in control on challenging terrain - without breaking your budget.\r'
	),
	(
		'BK-M47B-40',
		'\"Mountain-300 Black, 40\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'For true trail addicts.  An extremely durable bike that will go anywhere and keep you in control on challenging terrain - without breaking your budget.\r'
	),
	(
		'BK-M47B-44',
		'\"Mountain-300 Black, 44\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'For true trail addicts.  An extremely durable bike that will go anywhere and keep you in control on challenging terrain - without breaking your budget.\r'
	),
	(
		'BK-M47B-48',
		'\"Mountain-300 Black, 48\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'For true trail addicts.  An extremely durable bike that will go anywhere and keep you in control on challenging terrain - without breaking your budget.\r'
	),
	(
		'BK-M68B-38',
		'\"Mountain-200 Black, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M68B-42',
		'\"Mountain-200 Black, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M68B-46',
		'\"Mountain-200 Black, 46\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M68S-38',
		'\"Mountain-200 Silver, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M68S-42',
		'\"Mountain-200 Silver, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M68S-46',
		'\"Mountain-200 Silver, 46\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'Serious back-country riding. Perfect for all levels of competition. Uses the same HL Frame as the Mountain-100.\r'
	),
	(
		'BK-M82B-38',
		'\"Mountain-100 Black, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82B-42',
		'\"Mountain-100 Black, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82B-44',
		'\"Mountain-100 Black, 44\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82B-48',
		'\"Mountain-100 Black, 48\"',
		'Mountain Bikes',
		'Bikes',
		'Black',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82S-38',
		'\"Mountain-100 Silver, 38\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82S-42',
		'\"Mountain-100 Silver, 42\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
		'BK-M82S-44',
		'\"Mountain-100 Silver, 44\"',
		'Mountain Bikes',
		'Bikes',
		'Silver',
		'\"Top-of-the-line competition mountain bike. Performance-enhancing options include the innovative HL Frame, super-smooth front suspension, and traction for all terrain.\"\r'
	),
	(
......
```


## Project/Details of work system

##### `schema.sql`<br>
Create: 25 ก.พ. 2567 เวลา 23:03<br>
Update: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
CREATE TABLE `Reservation` (
	`QueueNumber` INT NOT NULL,
	`PatientName` VARCHAR(100) NULL,
	`TreatmentTypeCode` INT NULL,
	`DoctorID` INT NULL,
	`RoomNumber` INT NULL,
	`ExaminationLabel` VARCHAR(100) NULL,
	`AppointmentTime` DATETIME NULL
);

ALTER TABLE `Reservation` ADD PRIMARY KEY (`QueueNumber`);

CREATE TABLE `TreatmentRoom` (`RoomNumber` INT NOT NULL, `RoomType` VARCHAR(100) NULL, `RoomName` VARCHAR(100) NULL, `SupervisorName` VARCHAR(100) NULL);

ALTER TABLE `TreatmentRoom` ADD PRIMARY KEY (`RoomNumber`);

CREATE TABLE `Appointment` (`AppointmentID` INT NOT NULL, `ReservationQueueNumber` INT NULL);

ALTER TABLE `Appointment` ADD PRIMARY KEY (`AppointmentID`);

CREATE TABLE `ExaminationResult` (
	`ExaminationID` INT NOT NULL,
	`PatientID` INT NULL,
	`FirstName` VARCHAR(100) NULL,
	`TreatmentTypeCode` INT NULL,
	`TreatmentDetails` VARCHAR(100) NULL,
	`ExaminationRoom` VARCHAR(100) NULL,
	`DoctorID` INT NULL,
	`DoctorName` VARCHAR(100) NULL,
	`TreatmentDate` DATE NULL
);

ALTER TABLE `ExaminationResult` ADD PRIMARY KEY (`ExaminationID`);

CREATE TABLE `Patient` (`PatientID` INT NOT NULL, `FirstName` VARCHAR(100) NULL, `LastName` VARCHAR(100) NULL);

ALTER TABLE `Patient` ADD PRIMARY KEY (`PatientID`);

CREATE TABLE `Doctor` (`DoctorID` INT NOT NULL, `TreatmentTypeCode` INT NULL, `Expertise` VARCHAR(100) NULL, `DoctorName` VARCHAR(100) NULL, `AssistantID` INT NULL, `AssistantName` VARCHAR(100) NULL);

ALTER TABLE `Doctor` ADD PRIMARY KEY (`DoctorID`);

ALTER TABLE `ExaminationResult` ADD CONSTRAINT `examinationresult_patientid_foreign` FOREIGN KEY (`PatientID`) REFERENCES `Patient` (`PatientID`);

ALTER TABLE `Reservation` ADD CONSTRAINT `reservation_doctorid_foreign` FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`DoctorID`);

ALTER TABLE `Appointment` ADD CONSTRAINT `appointment_reservationqueuenumber_foreign` FOREIGN KEY (`ReservationQueueNumber`) REFERENCES `Reservation` (`QueueNumber`);

ALTER TABLE `Reservation` ADD CONSTRAINT `reservation_roomnumber_foreign` FOREIGN KEY (`RoomNumber`) REFERENCES `TreatmentRoom` (`RoomNumber`);

ALTER TABLE `ExaminationResult` ADD CONSTRAINT `examinationresult_doctorid_foreign` FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`DoctorID`);

```
