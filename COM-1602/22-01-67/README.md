`select.sql`<br>
Create: 22 ม.ค. 2567 time 14:43<br>
Update: 10 ก.ย. 2567 time 16:53<br>
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
