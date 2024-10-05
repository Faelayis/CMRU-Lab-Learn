<?php
include("get_enum_values.php");

$valid_days_of_week = get_enum_values($db, 'reservations', 'day_of_week');
$valid_time_slots = get_enum_values($db, 'reservations', 'time_slot_1');
$valid_goto_slots = get_enum_values($db, 'reservations', 'goto_slot_1');
$fields_to_validate = [
   'day_of_week' => $valid_days_of_week,
   'time_slot_1' => $valid_time_slots,
   'goto_slot_1' => $valid_goto_slots,
];
