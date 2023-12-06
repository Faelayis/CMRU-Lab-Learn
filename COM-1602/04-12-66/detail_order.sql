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