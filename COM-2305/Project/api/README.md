`connected.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```php
<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "com_2305-project";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

```
