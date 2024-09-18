<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   include("../../functions/previous_page.php");
} else {
   switch (mysqli_errno($db)) {
      case '1062':
         include("../../functions/previous_page.php");
         break;
      default:
         echo "Error: " . $query . "<br>" . mysqli_error($db);
         break;
   }
}

mysqli_stmt_close($stmt);
mysqli_close($db);
