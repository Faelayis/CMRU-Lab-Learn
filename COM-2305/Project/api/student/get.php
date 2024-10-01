<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");

include("../connected.php");

$query = "SELECT * FROM `student list`";
$students = array();

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_execute($stmt);
   $result = mysqli_stmt_get_result($stmt);

   if (mysqli_num_rows($result) > 0) {
      while ($row = mysqli_fetch_assoc($result)) {
         $students[] = $row;
      }
   }

   echo json_encode($students);
} else {
   echo json_encode(array("error" => "Failed to prepare the SQL statement."));
   exit();
}

mysqli_stmt_close($stmt);
mysqli_close($db);
