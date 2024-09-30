<?php
header('Content-Type: application/json');

include("../connected.php");
include("../../function/reservation/get_enum_values.php");

$response = [
   'days_of_week' => get_enum_values($db, 'reservations', 'day_of_week'),
   'time_slots' => get_enum_values($db, 'reservations', 'time_slot_1'),
   'goto_slots' => get_enum_values($db, 'reservations', 'goto_slot_1')
];

echo json_encode($response);

mysqli_close($db);
