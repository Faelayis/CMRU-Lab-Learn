<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_SESSION['student_name'])) {
      echo "Welcome " . $_SESSION['student_name'] . "<br>";
   } else {
      echo "No session information available. <br>";
   }
   ?>
   <a href="logout.php">Logout</a><br>
   <a href="login.php">Login</a>
</body>

</html>