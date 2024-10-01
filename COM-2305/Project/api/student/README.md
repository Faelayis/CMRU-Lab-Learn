`get.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 1 ต.ค. 2567 เวลา 14:47<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

include("../connected.php");

$query = "SELECT * FROM `student list`";
$students = array();

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_execute($stmt);
   $result = mysqli_stmt_get_result($stmt);

   if (mysqli_num_rows($result) > 0) {
      while ($row = mysqli_fetch_assoc($result)) {
         $students[] = $row;
      }
   }

   echo json_encode($students);
} else {
   echo json_encode(array("error" => "Failed to prepare the SQL statement."));
   exit();
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`schema.sql`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```sql
CREATE TABLE `student list` (`id` int(11) NOT NULL, `section` int(11) DEFAULT NULL, `name` varchar(255) DEFAULT NULL, `status` varchar(50) DEFAULT NULL)

```
