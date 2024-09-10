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
