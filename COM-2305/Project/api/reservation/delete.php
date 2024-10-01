<?php
// header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

include("../connected.php");
include("../../function/reservation/get_enum_values.php");
include("../../function/page.php");

$reservation_id = isset($_GET['id']) ? intval($_GET['id']) : 0;

if ($reservation_id <= 0) {
   echo json_encode(array("error" => "Invalid reservation ID"));
   mysqli_close($db);
   exit();
}

$stmt = mysqli_prepare($db, "DELETE FROM reservations WHERE reservation_id = ?");

if ($stmt === false) {
   echo json_encode(array("error" => "Error preparing statement: " . mysqli_error($db)));
   mysqli_close($db);
   exit();
}

mysqli_stmt_bind_param($stmt, "i", $reservation_id);

if (mysqli_stmt_execute($stmt)) {
   echo json_encode(array("success" => "Reservation deleted successfully"));
} else {
   echo json_encode(array("error" => "Error deleting reservation: " . mysqli_stmt_error($stmt)));
}

previousPage();

mysqli_stmt_close($stmt);
mysqli_close($db);
