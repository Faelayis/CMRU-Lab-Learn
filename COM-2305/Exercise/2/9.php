<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if (isset($_GET['username']) && isset($_GET['email']) && isset($_GET['password'])) {
      $username = htmlspecialchars($_GET['username']);
      $email = htmlspecialchars($_GET['email']);
      $password = htmlspecialchars($_GET['password']);

      echo "<h2>ข้อมูลที่ได้รับ:</h2>";
      echo "ชื่อผู้ใช้: " . $username . "<br>";
      echo "อีเมล: " . $email . "<br>";
      echo "รหัสผ่าน: " . $password . "<br>";
   } else {
   ?>
      <h2>สมัครสมาชิก</h2>
      <form method="get" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>">
         ชื่อผู้ใช้: <input type="text" name="username" required><br>
         อีเมล: <input type="email" name="email" required><br>
         รหัสผ่าน: <input type="password" name="password" required><br>
         <input type="submit" value="สมัครสมาชิก">
      </form>
   <?php
   }
   ?>
</body>

</html>