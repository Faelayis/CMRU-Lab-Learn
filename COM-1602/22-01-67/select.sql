-- 1
SELECT * FROM Suppiler WHERE Address Like %Changphunk%

-- 2
SELECT * FROM Product_461 WHERE NOT LIKE '%053%';

-- 3
SELECT * FROM Product_461 WHERE NameProduct LIKE '%pen%';

-- 4
SELECT * FROM Product_461 WHERE Price < 150 ORDER BY NameProduct DESC;

-- 6
SELECT * FROM DetailOrder_461 WHERE Amount > 100;
