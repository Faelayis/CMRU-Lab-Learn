`init.ps1`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 12:39<br>
```ps1
Set-Location C:\xampp\mysql\bin
.\mysql.exe -u root -p

use faelayis

alter table supplier461 modify name_sup varchar(30);

alter table supplier461 add tel int(9);

alter table supplier461 add zipcode int(6);

alter table supplier461 drop zipcode;

show create table supplier461;
```
