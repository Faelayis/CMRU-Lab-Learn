`init.ps1`<br>
Create: 27 พ.ย. 2566 time 16:55<br>
Update: 4 ธ.ค. 2566 time 17:04<br>
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
