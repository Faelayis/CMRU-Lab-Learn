`table.sql`<br>
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
