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
SELECT *
FROM `product_461`;

SELECT *
FROM `sales_461`;

-- 9
DELETE FROM product_461
WHERE ProductID = 'ProductID';

-- 10
DELETE FROM sales_461
WHERE IDorder = 'Order';

-- 11
CREATE TABLE profit_461 AS
SELECT *,
   Quantity * UnitCost AS SalesCost,
   Quantity * UnitPrice AS SalesPrice,
   (Quantity * UnitPrice) - (Quantity * UnitCost) AS Profit
FROM sales_461;

-- 13
SELECT p.Category,
   sum(x.Profit) AS sumprofit
FROM product_461 AS p
   INNER JOIN profit_461 AS x ON p.ProductID = x.ProductID
GROUP BY p.Category;

-- 14
SELECT ResellerID,
   sum(profit) AS sumprofit
FROM profit_461
GROUP BY ResellerID;

-- 15
SELECT Category,
   COUNT(*) AS TotalProducts
FROM product_461
GROUP BY Category;