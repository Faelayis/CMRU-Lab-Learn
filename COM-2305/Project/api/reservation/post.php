<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

$response = [];

try {
   if ($_SERVER["REQUEST_METHOD"] !== "POST") {
      http_response_code(405);
      echo json_encode(['status_code' => http_response_code(), "error" => "Invalid request method"]);
      exit;
   }

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
