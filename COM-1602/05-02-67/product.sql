CREATE TABLE products (
   product_code VARCHAR(10),
   product_type VARCHAR(50),
   price_per_unit DECIMAL(10, 2)
);

INSERT INTO products (product_code, product_type, price_per_unit)
VALUES ('C01', 'Water Color'  ,  50),
       ('C02', 'Color Pencils', 120);