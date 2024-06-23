![Preview Image](./README.png)

`billorder.sql`<br>
สร้าง: 6 ธ.ค. 2566 เวลา 16:35<br>
```sql
-- Create Billorder Table
CREATE TABLE Billorder_461 (
   IdBillorder VARCHAR(10) PRIMARY KEY,
   Id_Sup VARCHAR(10)
) ENGINE = MYISAM;

-- Add Billorder Data
INSERT INTO Billorder_461 (IdBillorder, Id_Sup)
VALUES ('BC001', 'SP001'),
   ('BC002', 'SP002'),
   ('BC003', 'SP003'),
   ('BC004', 'SP004');

-- Show Billorder data
SELECT *
FROM Billorder_461;
```
`detail_order.sql`<br>
สร้าง: 6 ธ.ค. 2566 เวลา 16:35<br>
```sql
-- Create DetailOrder Table
CREATE TABLE DetailOrder_461 (
   IdBillorder CHAR(5),
   IdProduct CHAR(4),
   Amount INT(8)
) ENGINE = MYISAM;

-- Add DetailOrder Data
INSERT INTO DetailOrder_461 (IdBillorder, IdProduct, Amount)
VALUES ('BC001', 'P01', 100),
   ('BC001', 'P02', 200),
   ('BC001', 'P03', 100),
   ('BC001', 'P03', 100),
   ('BC002', 'P02', 300),
   ('BC002', 'P03', 300),
   ('BC003', 'P03', 50),
   ('BC003', 'B02', 100),
   ('BC004', 'L01', 20);

-- Show DetailOrder data
SELECT *
FROM DetailOrder_461;
```
`product.sql`<br>
สร้าง: 6 ธ.ค. 2566 เวลา 16:35<br>
```sql
-- Create Product Table
CREATE TABLE Product_461 (
   IdProduct CHAR(3) PRIMARY KEY,
   NameProduct VARCHAR(20),
   Price INT(4)
) ENGINE = MYISAM;

-- Add Product Data 
INSERT INTO Product_461 (IdProduct, NameProduct, Price)
VALUES ('P01', 'Paper A4 70 g.', 105),
   ('P02', 'Paper A4 80 g.', 120),
   ('P03', 'Paper F4 80 g.', 130),
   ('P04', 'Paper B2 80 g.', 150),
   ('B01', 'Blue Pen', 25),
   ('B02', 'Red Pen', 15),
   ('L01', 'Toner printer', 5500);

-- Show product data 
SELECT *
FROM Product_461;
```
