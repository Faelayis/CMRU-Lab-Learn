<?php
include("./connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   echo "New record created successfully";
} else {
   echo "Error: " . $query . "<br>" . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);
