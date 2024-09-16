<?php
include("./connected_database.php");

if ($_SERVER["REQUEST_METHOD"] == "POST") {
   $fac_id = $_POST['id'];
   $fac_name = $_POST['name'];

   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);
   mysqli_stmt_bind_param($stmt, "is", $fac_id, $fac_name);

   if (mysqli_stmt_execute($stmt)) {
      echo "New record created successfully";
   } else {
      echo "Error: " . $sql . "<br>" . mysqli_error($db);
   }

   mysqli_stmt_close($stmt);
   mysqli_close($db);
}
