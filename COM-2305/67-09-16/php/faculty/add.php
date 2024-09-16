<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
   include("../../../Exercise/8/connected_database.php");

   $fac_id = $_POST['id'];
   $fac_name = $_POST['name'];

   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);
   mysqli_stmt_bind_param($stmt, "is", $fac_id, $fac_name);

   if (mysqli_stmt_execute($stmt)) {
      include("../../functions/previous_page.php");
   } else {
      switch (mysqli_errno($db)) {
         case '1062':
            include("../../functions/previous_page.php");
            break;

         default:
            echo "Error: " . $sql . "<br>" . mysqli_error($db);
            break;
      }
   }

   mysqli_stmt_close($stmt);
   mysqli_close($db);
}
