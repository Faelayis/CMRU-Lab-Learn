<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_GET['username']) && isset($_GET['password'])) {
      $username = htmlspecialchars($_GET['username']);
      $password = htmlspecialchars($_GET['password']);

      echo "<h2>ข้อมูลที่ได้รับ:</h2>";
      echo "Username: " . $username . "<br>";
      echo "Password: " . $password . "<br>";
   } else {
   ?>
      <h2>กรุณาป้อนเพื่อ Login</h2>
      <form method="get" action="">
         Username: <input type="text" name="username"><br><br>
         Password: <input type="text" name="password"><br><br>
         <input type="submit" value="ตกลง">
         <input type="reset" value="ยกเลิก">
      </form>
   <?php
   }
   ?>
</body>

</html>

</html>