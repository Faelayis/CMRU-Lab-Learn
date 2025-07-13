`login.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="setcookie.php">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required><br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br>
      <button type="submit">Login</button>
   </form>
</body>

</html>
```
`logout.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
<?php
setcookie("first_name", '', time() - 3600, "/");
setcookie("last_name", '', time() - 3600, "/");
header("Refresh:0; url=welcome.php");

```
`setcookie.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
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

```
`welcome.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
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
```
