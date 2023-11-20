Set-Location C:\xampp\mysql\bin

create database faelayis;
use faelayis

# Create Table
create table supplieir000 (
   id_sup char(5) not null,
   name_sup varchar(20),
   address varchar(50),
   primary key (id_sup)
) engine = myisam;
