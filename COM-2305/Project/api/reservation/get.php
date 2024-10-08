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
