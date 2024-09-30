<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "com_2305-project";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}
