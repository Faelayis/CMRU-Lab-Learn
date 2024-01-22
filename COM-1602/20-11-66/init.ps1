Set-Location C:\xampp\mysql\bin
.\mysql.exe -u root -p

create database faelayis;
use faelayis

# Create Table
create table Supplier_461 (
   id_sup char(5) not null,
   name_sup varchar(20),
   address varchar(50),
   primary key (id_sup)
) engine = myisam;

# Insert Table
insert into Supplier_461 values('SP001', 'Somjai Company', '120 Changphuak Chiangmai'),
                       ('SP002', 'ABC Company', '50 Chotana road Chiangmai'),
                       ('SP003', 'Paper Service', '50 Intayonyot road Lamphun'),
                       ('SP004', 'ComTect', '33 Moo 3 T.Baanklan Lamphun'),
                       ('SP005', 'Parada Company', '102 T.Changphuak');

# Show Table Data
select * from Supplier_461;