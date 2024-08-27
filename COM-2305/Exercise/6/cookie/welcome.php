<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_COOKIE['first_name']) && isset($_COOKIE['last_name'])) {
      echo "Welcome, " . $_COOKIE['first_name'] . " " . $_COOKIE['last_name'] . "<br>";
   } else {
      echo "No user information available. <br>";
   }
   ?>
   <a href="logout.php">Logout</a><br>
   <a href="login.php">Login</a>
</body>

</html>