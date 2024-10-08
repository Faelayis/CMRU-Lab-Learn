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
