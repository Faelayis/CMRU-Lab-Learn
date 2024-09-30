<?php
include("./connected_database.php");

$sql = "UPDATE faculty SET Fac_id=?, Fac_name=? WHERE Fac_id=?";
$stmt = mysqli_prepare($db, $sql);

if ($stmt) {
   mysqli_stmt_bind_param($stmt, "isi", $id, $name, $fac_id);
   if (mysqli_stmt_execute($stmt)) {
      echo "Record updated successfully.";
   } else {
      echo "Error updating record: " . mysqli_stmt_error($stmt);
   }
   mysqli_stmt_close($stmt);
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}
