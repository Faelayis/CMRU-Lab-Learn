<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['Fac_id'];
$query = "DELETE FROM faculty WHERE Fac_id = ?";

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_bind_param($stmt, "i", $faculty_id);

   if (mysqli_stmt_execute($stmt)) {
      previousPage();
      exit();
   } else {
      echo "Error deleting record: " . mysqli_error($db);
   }
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);
