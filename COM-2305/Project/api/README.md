`connected.php`<br>
Create: 1 ต.ค. 2567 time 03:36<br>
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
