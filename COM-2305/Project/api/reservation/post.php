<?php
if ($_SERVER["REQUEST_METHOD"] !== "POST") return;

header("Content-Type: application/json; charset=UTF-8");

include("../connected.php");
include("../../function/reservation/valid-reservation.php");
include("../../function/reservation/valid-student.php");
include("../../function/previous_page.php");

$reservation_date = $_POST['reservation_date'];
$student_id = $_POST['student_id'];
$status = $_POST['status'];
$day_of_week = $_POST['day_of_week'];
$time_slot_1 = $_POST['time_slot_1'];
$goto_slot_1 = $_POST['goto_slot_1'];
$time_slot_2 = $_POST['time_slot_2'];
$goto_slot_2 = $_POST['goto_slot_2'];

$errors = [];

foreach ($fields_to_validate as $field => $valid_values) {
   if (!in_array($$field, $valid_values)) {
      $errors[] = "Invalid $field value: {$$field}. Valid values are: " . implode(", ", $valid_values);
   }
}

if (!is_valid_student($db, $student_id)) {
   echo json_encode(["error" => "Invalid student_id: $student_id"]);
   mysqli_close($db);
   return;
}

if (!empty($errors)) {
   echo json_encode(["error" => $errors]);
   return;
}

$query = "INSERT INTO reservations (student_id, reservation_date, status, day_of_week, time_slot_1, goto_slot_1, time_slot_2, goto_slot_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "isssssss", $student_id, $reservation_date, $status, $day_of_week, $time_slot_1, $goto_slot_1, $time_slot_2, $goto_slot_2);

if (mysqli_stmt_execute($stmt)) {
   echo json_encode(["message" => "Reservation created successfully"]);
} else {
   switch (mysqli_errno($db)) {
      case 1062:
         echo json_encode(["error" => "Duplicate entry"]);
         break;
      default:
         echo json_encode(["error" => "Error: " . $query . "<br>" . mysqli_error($db)]);
         break;
   }
}

previousPage();
mysqli_stmt_close($stmt);
mysqli_close($db);
