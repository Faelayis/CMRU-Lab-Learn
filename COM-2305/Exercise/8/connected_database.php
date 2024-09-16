<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "18-com_2305";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_errno == 1049) {
   die("Unknown database: " . $dbname);
}

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

if (!mysqli_set_charset($db, "utf8")) {
   die("Error loading character set utf8: " . mysqli_error($db));
}

// echo "Connected successfully";
