<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {  
   $username = $_POST['username'];
   $password = $_POST['password'];

   if ($username == "fae" && $password == "123") {
      setcookie("first_name", "test", time() + 3600, "/");
      setcookie("last_name", "test", time() + 3600, "/");
      header("Location: welcome.php");
      // require("./welcome.php");
      exit();
   } else {
      echo "Invalid credentials. <br>";
      echo "<a href=\"login.php\">Back to Login</a>";
   }
}
