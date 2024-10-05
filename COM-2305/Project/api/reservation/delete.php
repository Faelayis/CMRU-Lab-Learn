<?php
header("Access-Control-Allow-Origin: *");
// header("Content-Type: application/json; charset=UTF-8");

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
