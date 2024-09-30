<?php
include("./connected_database.php");

$search = isset($_GET['search']) ? $_GET['search'] : ' ';
$searchTerm = "%$search%";

$sql = "SELECT Fac_id, Fac_name FROM faculty WHERE Fac_id LIKE ? OR Fac_name LIKE ?";

$stmt = mysqli_prepare($db, $sql);
if ($stmt === false) {
   die('Prepare failed: ' . htmlspecialchars(mysqli_error($db)));
}

mysqli_stmt_bind_param($stmt, "ss", $searchTerm, $searchTerm);

mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

mysqli_stmt_close($stmt);
mysqli_close($db);
