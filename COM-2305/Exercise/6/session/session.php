<?php
session_start();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
   $username = $_POST['username'];
   $password = $_POST['password'];

   if ($username == 'fae' && $password == '123') {
      $_SESSION['name'] = 'fae';
      $_SESSION['username'] = 'fae';
      $_SESSION['password'] = '123';
      header('Location: welcome.php');
      exit();
   } else {
      echo "Invalid credentials. <br>";
      echo "<a href=\"login.php\">Back to Login</a>";
   }
}
