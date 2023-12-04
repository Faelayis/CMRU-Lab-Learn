`init.ps1`<br>
สร้าง: 20 พ.ย. 2566 เวลา 15:58<br>
อัปเดต: 4 ธ.ค. 2566 เวลา 17:04<br>
```ps1
Set-Location C:\xampp\mysql\bin
.\mysql.exe -u root -p

create database faelayis;
use faelayis

# Create Table
create table supplier461 (
   id_sup char(5) not null,
   name_sup varchar(20),
   address varchar(50),
   primary key (id_sup)
) engine = myisam;

# Insert Table
insert into supplier461 values('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
                       ('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
                       ('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
                       ('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
                       ('SP005', 'Parada Company', '102 T.Changphuak');

# Show Table Data
select * from supplier461;
```
`schema.sql`<br>
สร้าง: 20 พ.ย. 2566 เวลา 16:25<br>
แก้ไขล่าสุด: เวลา 16:38<br>

```sql
-- Create database
CREATE DATABASE faelayis;

-- Switch to the database
USE faelayis;

-- Create table
CREATE TABLE supplier461 (
   id_sup CHAR(5) NOT NULL,
   name_sup VARCHAR(20),
   address VARCHAR(50),
   PRIMARY KEY (id_sup)
) ENGINE = MyISAM;

-- Insert data into the table
INSERT INTO supplier461 VALUES
   ('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
   ('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
   ('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
   ('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
   ('SP005', 'Parada Company', '102 T.Changphuak');

-- Show table data
SELECT * FROM supplier461;

```
