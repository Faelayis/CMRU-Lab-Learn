`product.sql`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 10 ก.ย. 2567 เวลา 16:53<br>
```sql
CREATE TABLE products (product_code VARCHAR(10), product_type VARCHAR(50), price_per_unit DECIMAL(10, 2));

INSERT INTO
	products (product_code, product_type, price_per_unit)
VALUES
	('C01', 'Water Color', 50),
	('C02', 'Color Pencils', 120);

```
`product_app.sql`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 10 ก.ย. 2567 เวลา 16:53<br>
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
`update-delete.sql`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
```sql

```
