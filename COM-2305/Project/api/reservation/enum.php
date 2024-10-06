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
