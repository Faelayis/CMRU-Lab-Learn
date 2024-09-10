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
