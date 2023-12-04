-- Create Product
CREATE TABLE Product (
    IdProduct CHAR(3) PRIMARY KEY,
    NameProduct VARCHAR(20),
    Price INT(4)
) ENGINE = MyISAM;

-- Add Product Data
INSERT INTO Product (IdProduct, NameProduct, Price) VALUES
    ('P01', 'Paper A4 70 g.', 105),
    ('P02', 'Paper A4 80 g.', 120),
    ('P03', 'Paper F4 80 g.', 130),
    ('P04', 'Paper B2 80 g.', 150),
    ('B01', 'Blue Pen', 25),
    ('B02', 'Red Pen', 15),
    ('L01', 'Toner printer', 5500);

SELECT * FROM Product;

-- Create Billorder
CREATE TABLE Billorder (
    IdBillorder CHAR(4) PRIMARY KEY,
    Id_Sup CHAR(3),
    FOREIGN KEY (Id_Sup) REFERENCES Supplier(Id_Sup)
) ENGINE = MyISAM;

-- Add Billorder Data
INSERT INTO Billorder (IdBillorder, Id_Sup) VALUES
    ('BC001', 'SP001'),
    ('BC002', 'SP002'),
    ('BC003', 'SP003'),
    ('BC004', 'SP004');

SELECT * FROM Billorder;

-- Create DetailOrder Data
CREATE TABLE DetailOrder (
    IdBillorder CHAR(4) PRIMARY KEY,
    IdProduct CHAR(3),
    Amount INT(8)
) ENGINE = MyISAM;

-- Add DetailOrder Data
INSERT INTO DetailOrder (IdBillorder, IdProduct, Amount) VALUES
    ('BC001', 'P01', 100),
    ('BC001', 'P02', 200),
    ('BC001', 'P03', 100),
    ('BC001', 'P03', 100),
    ('BC002', 'P02', 300),
    ('BC002', 'P03', 300),
    ('BC003', 'P03', 50),
    ('BC003', 'B02', 100),
    ('BC004', 'L01', 20);

-- Show product data
SELECT * FROM DetailOrder;