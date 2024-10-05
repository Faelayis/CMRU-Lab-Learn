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
