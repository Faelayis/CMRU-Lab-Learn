`3.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```php
<?php
include("./connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   echo "New record created successfully";
} else {
   echo "Error: " . $query . "<br>" . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`connected_database.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "18-com_2305";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_errno == 1049) {
   die("Unknown database: " . $dbname);
}

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

if (!mysqli_set_charset($db, "utf8")) {
   die("Error loading character set utf8: " . mysqli_error($db));
}

// echo "Connected successfully";

```
