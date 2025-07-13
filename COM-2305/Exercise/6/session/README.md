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
   <form method="post" action="session.php">
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
session_start();
session_destroy();
// or
// unset($_SESSION["name"]);
// unset($_SESSION["username"]);
// unset($_SESSION["password"]);
header("Refresh:0; url=welcome.php");

```
`session.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
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

```
`welcome.php`<br>
Create: 27 ส.ค. 2567 เวลา 15:47<br>
```php
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
```
