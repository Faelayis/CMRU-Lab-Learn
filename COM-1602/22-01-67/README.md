`select.sql`<br>
สร้าง: 22 ม.ค. 2567 เวลา 14:43<br>
แก้ไขล่าสุด: เวลา 15:09<br>

```sql
-- 1
SELECT * FROM Supplier_461 WHERE address LIKE '%Changphuak%';

-- 2
SELECT * FROM Product_461 WHERE NOT LIKE '%053%';

-- 3
SELECT * FROM Product_461 WHERE NameProduct LIKE '%pen%';

-- 4
SELECT * FROM Product_461 WHERE Price < 150 ORDER BY NameProduct DESC;

-- 5
SELECT DISTINCT IdProduct FROM DetailOrder_461;

-- 6
SELECT * FROM DetailOrder_461 WHERE Amount > 100;

-- 7
SELECT d.IdProduct, SUM(d.Amount) AS TotalAmount, p.Price, SUM(d.Amount * p.Price) AS TotalPrice FROM DetailOrder_461 d JOIN Product_461 p ON d.IdProduct = p.IdProduct GROUP BY d.IdProduct, p.Price;

-- 8
SELECT IdProduct, Sum(Amount) as Total FROM DetailOrder_461 GROUP BY IdProduct HAVING Sum(Amount);

-- 9
SELECT b.IdProduct, b.NameProduct, Sum(a.Amount) as Total FROM DetailOrder_461 a, Product_461 b WHERE a.IdProduct = b.IdProduct GROUP BY b.IdProduct HAVING Sum(a.Amount) > 100;

-- 10
SELECT * FROM Product_461 WHERE NameProduct LIKE '%80 g.%';
```
