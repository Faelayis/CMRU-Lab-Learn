-- Create database
CREATE DATABASE faelayis;

-- Switch to the database
USE faelayis;

-- Create table
CREATE TABLE Supplier_461 (id_sup CHAR(5) NOT NULL, name_sup VARCHAR(20), address VARCHAR(50), PRIMARY KEY (id_sup)) ENGINE = MyISAM;

-- Insert data into the table
INSERT INTO
	Supplier_461
VALUES
	('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
	('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
	('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
	('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
	('SP005', 'Parada Company', '102 T.Changphuak');

-- Show table data
SELECT
	*
FROM
	Supplier_461;
