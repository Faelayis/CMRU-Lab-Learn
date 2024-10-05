`delete.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 14:47<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");
include("../../function/page.php");

$reservation_date = $_POST['reservation_date'];
$student_id = $_POST['student_id'];
$day_of_week = $_POST['day_of_week'];
$time_slot_1 = $_POST['time_slot_1'];
$goto_slot_1 = $_POST['goto_slot_1'];
$time_slot_2 =  $_POST['time_slot_2'] ?? null;
$goto_slot_2 =  $_POST['goto_slot_2'] ?? null;

if (!$reservation_date || !$student_id || !$day_of_week || !$time_slot_1 || !$goto_slot_1) {
   echo json_encode(array("error" => "Missing required parameters"));
   exit();
}

$query = "DELETE FROM reservations WHERE reservation_date = ? AND student_id = ? AND day_of_week = ? AND time_slot_1 = ? AND goto_slot_1 = ?";
$params = array($reservation_date, $student_id, $day_of_week, $time_slot_1, $goto_slot_1);
$types = "sssss";

if ($time_slot_2 !== null) {
   $query .= " AND time_slot_2 = ?";
   $params[] = $time_slot_2;
   $types .= "s";
}

if ($goto_slot_2 !== null) {
   $query .= " AND goto_slot_2 = ?";
   $params[] = $goto_slot_2;
   $types .= "s";
}

$stmt = mysqli_prepare($db, $query);
if ($stmt === false) {
   echo json_encode(array("error" => "Error preparing statement: " . mysqli_error($db)));
   mysqli_close($db);
   exit();
}

mysqli_stmt_bind_param($stmt, $types, ...$params);

if (mysqli_stmt_execute($stmt)) {
   echo json_encode(array("success" => "Reservation deleted successfully"));
} else {
   echo json_encode(array("error" => "Error deleting reservation: " . mysqli_stmt_error($stmt)));
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`enum.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 1 ต.ค. 2567 เวลา 14:47<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");

$response = [
   'days_of_week' => get_enum_values($db, 'reservations', 'day_of_week'),
   'time_slots' => get_enum_values($db, 'reservations', 'time_slot_1'),
   'goto_slots' => get_enum_values($db, 'reservations', 'goto_slot_1')
];

echo json_encode($response);

mysqli_close($db);

```
`get.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 1 ต.ค. 2567 เวลา 14:47<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

include("../connected.php");

if (isset($_GET['student_id'])) {
   $student_id = intval($_GET['student_id']);
   $sql = "SELECT * FROM reservations WHERE student_id = ?";
   $stmt = mysqli_prepare($db, $sql);
   mysqli_stmt_bind_param($stmt, "i", $student_id);
} else {
   $sql = "SELECT * FROM reservations";
   $stmt = mysqli_prepare($db, $sql);
}

mysqli_stmt_execute($stmt);

$result = mysqli_stmt_get_result($stmt);
$reservations = array();

while ($row = mysqli_fetch_assoc($result)) {
   $reservations[] = $row;
}

echo json_encode($reservations);

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`post.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
// header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

if ($_SERVER["REQUEST_METHOD"] !== "POST") return;

include("../connected.php");
include("../../function/reservation/valid-reservation.php");
include("../../function/reservation/valid-student.php");
include("../../function/page.php");

$reservation_date = $_POST['reservation_date'];
$student_id = $_POST['student_id'];
$status = $_POST['status'];
$day_of_week = $_POST['day_of_week'];
$time_slot_1 = $_POST['time_slot_1'];
$goto_slot_1 = $_POST['goto_slot_1'];
$time_slot_2 = $_POST['time_slot_2'] ?? null;
$goto_slot_2 = $_POST['goto_slot_2'] ?? null;

$errors = [];

foreach ($fields_to_validate as $field => $valid_values) {
   if (!in_array($$field, $valid_values)) {
      $errors[] = "Invalid $field value: {$$field}. Valid values are: " . implode(", ", $valid_values);
   }
}

if (!is_valid_student($db, $student_id)) {
   echo json_encode(["success" => false, "error" => "Invalid student_id: $student_id"]);
   mysqli_close($db);
   return;
}

if (!empty($errors)) {
   echo json_encode(["success" => false, "error" => $errors]);
   return;
}

$query = "SELECT * FROM reservations WHERE student_id = ? AND reservation_date = ?";
$stmt = mysqli_prepare($db, $query);
mysqli_stmt_bind_param($stmt, "is", $student_id, $reservation_date);
mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

if (mysqli_num_rows($result) > 0) {
   $query = "UPDATE reservations SET status = ?, day_of_week = ?, time_slot_1 = ?, goto_slot_1 = ?, time_slot_2 = ?, goto_slot_2 = ? WHERE student_id = ? AND reservation_date = ?";
   $stmt = mysqli_prepare($db, $query);
   mysqli_stmt_bind_param($stmt, "ssssssis", $status, $day_of_week, $time_slot_1, $goto_slot_1, $time_slot_2, $goto_slot_2, $student_id, $reservation_date);
} else {
   $query = "INSERT INTO reservations (student_id, reservation_date, status, day_of_week, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
   $stmt = mysqli_prepare($db, $query);
   mysqli_stmt_bind_param($stmt, "isssssss", $student_id, $reservation_date, $status, $day_of_week, $time_slot_1, $goto_slot_1, $time_slot_2, $goto_slot_2);
}

if (mysqli_stmt_execute($stmt)) {
   echo json_encode(["success" => true, "message" => "Reservation processed successfully"]);
} else {
   switch (mysqli_errno($db)) {
      case 1062:
         echo json_encode(["success" => false, "error" => "Duplicate entry"]);
         break;
      default:
         echo json_encode(["success" => false, "error" => "Error: " . $query . "<br>" . mysqli_error($db)]);
         break;
   }
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`schema.sql`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```sql
CREATE TABLE `reservations` (
	`reservation_id` int(11) NOT NULL AUTO_INCREMENT,
	`reservation_date` date NOT NULL,
	`student_id` int(11) NOT NULL,
	`status` varchar(50) DEFAULT NULL,
	`day_of_week` ENUM ('วันจันทร์', 'วันอังคาร', 'วันพุธ', 'วันพฤหัสบดี', 'วันศุกร์', 'วันเสาร์', 'วันอาทิตย์') NOT NULL,
	`time_slot_1` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45') NOT NULL,
	`goto_slot_1` ENUM ('ไปแม่ริม', 'ไปเวียงบัว') NOT NULL,
	`time_slot_2` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45'),
	`goto_slot_2` ENUM ('ไปแม่ริม', 'ไปเวียงบัว'),
	PRIMARY KEY (`reservation_id`)
);

```
