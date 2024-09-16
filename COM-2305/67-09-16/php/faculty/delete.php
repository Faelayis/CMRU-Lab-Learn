<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
   include("../../../Exercise/8/connected_database.php");

   $fac_id = $_POST['Fac_id'];
   $sql = "DELETE FROM faculty WHERE Fac_id = ?";

   if ($stmt = mysqli_prepare($db, $sql)) {
      mysqli_stmt_bind_param($stmt, "i", $fac_id);

      if (mysqli_stmt_execute($stmt)) {
         header("Location: " . $_SERVER['HTTP_REFERER']);
         exit();
      } else {
         echo "Error deleting record: " . mysqli_error($db);
      }

      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }

   mysqli_close($db);
}
