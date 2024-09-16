<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);
