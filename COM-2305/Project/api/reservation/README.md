`delete.php`<br>
Create: 1 ต.ค. 2567 time 14:47<br>
Update: 8 ต.ค. 2567 time 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");
include("../../function/page.php");

try {
   $reservation_date = $_POST['reservation_date'];
   $student_id = $_POST['student_id'];
   $day_of_week = $_POST['day_of_week'];
   $time_slot_1 = $_POST['time_slot_1'];
   $goto_slot_1 = $_POST['goto_slot_1'];
   $time_slot_2 =  $_POST['time_slot_2'] ?? null;
   $goto_slot_2 =  $_POST['goto_slot_2'] ?? null;

   if (!$reservation_date || !$student_id || !$day_of_week || !$time_slot_1 || !$goto_slot_1) {
      http_response_code(400);
      echo json_encode([
         'status_code' => http_response_code()
      ]);
      exit;
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
      throw new Exception("Failed to prepare statement");
   }

   mysqli_stmt_bind_param($stmt, $types, ...$params);

   if (!mysqli_stmt_execute($stmt)) {
      throw new Exception("Failed to execute statement");
   }

   http_response_code(200);
   echo json_encode([
      'status_code' => http_response_code()
   ]);
} catch (Exception $e) {
   http_response_code(500);
   echo json_encode([
      'status_code' => http_response_code(),
      'error' => $e->getMessage()
   ]);
} finally {
   if (isset($stmt) && $stmt !== false) {
      mysqli_stmt_close($stmt);
   }
   mysqli_close($db);
   exit;
}

```
`enum.php`<br>
Create: 1 ต.ค. 2567 time 03:36<br>
Update: 6 ต.ค. 2567 time 14:24<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Methods: GET");
header("Access-Control-Allow-Headers: Content-Type, Authorization, X-Requested-With");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");

$response = [];

try {
   $response = [
      'days_of_week' => get_enum_values($db, 'reservations', 'day_of_week'),
      'time_slots' => get_enum_values($db, 'reservations', 'time_slot_1'),
      'goto_slots' => get_enum_values($db, 'reservations', 'goto_slot_1')
   ];
   http_response_code(200);
} catch (Exception $e) {
   http_response_code(500);
} finally {
   mysqli_close($db);
   echo json_encode([
      'status_code' => http_response_code(),
      'data' => $response
   ]);
   exit;
}

```
`get.php`<br>
Create: 1 ต.ค. 2567 time 03:36<br>
Update: 8 ต.ค. 2567 time 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

try {
   if (isset($_GET['student_id'])) {
      $student_id = intval($_GET['student_id']);
      $sql = "SELECT * FROM reservations WHERE student_id = ?";
      $stmt = mysqli_prepare($db, $sql);
      if (!$stmt) {
         throw new Exception("Failed to prepare statement: " . mysqli_error($db));
      }
      mysqli_stmt_bind_param($stmt, "i", $student_id);
   } else {
      $sql = "SELECT * FROM reservations";
      $stmt = mysqli_prepare($db, $sql);
      if (!$stmt) {
         throw new Exception("Failed to prepare statement: " . mysqli_error($db));
      }
   }

   mysqli_stmt_execute($stmt);

   $result = mysqli_stmt_get_result($stmt);
   $reservations = array();

   while ($row = mysqli_fetch_assoc($result)) {
      $reservations[] = $row;
   }

   echo json_encode($reservations);
} catch (Exception $e) {
   echo json_encode(array("error" => $e->getMessage()));
} finally {
   if (isset($stmt)) {
      mysqli_stmt_close($stmt);
   }
   mysqli_close($db);
   exit();
}

```
`post.php`<br>
Create: 1 ต.ค. 2567 time 03:36<br>
Update: 8 ต.ค. 2567 time 13:05<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

$response = [];

try {
   if ($_SERVER["REQUEST_METHOD"] !== "POST") {
      http_response_code(405);
      echo json_encode(['status_code' => http_response_code(), "error" => "Invalid request method"]);
      exit;
   }

   include("../../function/reservation/valid-reservation.php");
   include("../../function/reservation/valid-student.php");

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
      http_response_code(400);
      echo json_encode(['status_code' => http_response_code(), "error" => "Invalid student ID"]);
      exit;
   }

   if (!empty($errors)) {
      http_response_code(400);
      echo json_encode(['status_code' => http_response_code(), "errors" => $errors]);
      exit;
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
      http_response_code(200);
      $response = ["message" => "Reservation successfully saved"];
   } else {
      switch (mysqli_errno($db)) {
         case 1062:
            http_response_code(409);
            $response = ["error" => "Duplicate entry"];
            break;
         default:
            http_response_code(500);
            $response = ["error" => "Internal server error"];
            break;
      }
   }

   echo json_encode(['status_code' => http_response_code(), 'data' => $response]);
} catch (Exception $e) {
   http_response_code(500);
   echo json_encode(['status_code' => http_response_code(), 'error' => 'An unexpected error occurred', 'details' => $e->getMessage()]);
} finally {
   if (isset($stmt)) {
      mysqli_stmt_close($stmt);
   }
   if (isset($db)) {
      mysqli_close($db);
   }
}
exit;

```
`schema.sql`<br>
Create: 1 ต.ค. 2567 time 03:36<br>
Update: 6 ต.ค. 2567 time 02:16<br>
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
