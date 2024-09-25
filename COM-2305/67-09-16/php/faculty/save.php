<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

function addFaculty($db, $id, $name) {
   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);

   if ($stmt) {
      mysqli_stmt_bind_param($stmt, "is", $id, $name);
      if (mysqli_stmt_execute($stmt)) {
         echo "Record added successfully.";
      } else {
         echo "Error adding record: " . mysqli_stmt_error($stmt);
      }
      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }
}

function updateFaculty($db, $id, $name, $fac_id) {
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
}

$fac_id = $_POST['fac_id'];
$id = $_POST['id'];
$name = $_POST['name'];

if (!empty($id) && !empty($name)) {
   if (empty($fac_id)) {
      addFaculty($db, $id, $name);
   } else {
      updateFaculty($db, $id, $name, $fac_id);
   }
   previousPage();
} else {
   echo "All fields not fill.";
}


mysqli_close($db);
