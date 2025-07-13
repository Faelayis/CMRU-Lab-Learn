`1.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<?php
$studentID = "123456789";
$name = "Faelayis";
$section = "2";

echo "รหัสนักศึกษา: " . $studentID . "<br>";
echo "ชื่อ-นามสกุล: " . $name . "<br>";
echo "Section: " . $section;

```
`2.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<?php
$studentID = "123456789";
$name = "Faelayis";
$section = "2";

print "รหัสนักศึกษา: " . $studentID . "<br>";
print "ชื่อ-นามสกุล: " . $name . "<br>";
print "Section: " . $section;

```
`3.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<?php
$courseID = "COM 2305-63";
$courseName = "การเขียนโปรแกรมเว็บ";
$credits = 3;

printf("รหัสวิชา: %s<br>", $courseID);
printf("ชื่อวิชา: %s<br>", $courseName);
printf("หน่วยกิต: %d", $credits);

```
`4.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<?php
$courseID = "COM 2305-63";
$courseName = "การเขียนโปรแกรมเว็บ";
$credits = 3;

$courseInfo = sprintf("รหัสวิชา: %s<br>ชื่อวิชา: %s<br>หน่วยกิต: %d", $courseID, $courseName, $credits);

echo $courseInfo;

```
`5.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
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
```
`6.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" accept="">
      <p>ข้อเสนอแนะ</p>
      <textarea name="comment" cols="30" rows="10"></textarea><br>
      <input type="submit" name="submit" value="ตกลง"><br>
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $text = $_GET['comment'];
      print "<textarea rows=5 cols=30>$text</textarea>";
   }
   ?>
</body>

</html>
```
`7.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   if ($_SERVER["REQUEST_METHOD"] == "GET" && isset($_GET['number1']) && isset($_GET['number2']) && isset($_GET['number3'])) {
      $number1 = floatval($_GET['number1']);
      $number2 = floatval($_GET['number2']);
      $number3 = floatval($_GET['number3']);
      $sum = $number1 + $number2 + $number3;
      $average = $sum / 3;

      echo "<h2>ผลลัพธ์ที่ได้รับ:</h2>";
      echo "ผลรวมของตัวเลข: " . $sum . "<br>";
      echo "ค่าเฉลี่ยของตัวเลข: " . $average . "<br>";
   } else {
   ?>
      <h2>กรอกตัวเลข 3 จำนวน</h2>
      <form method="get" action="">
         ตัวเลขที่ 1 <input type="text" name="number1"><br>
         ตัวเลขที่ 2 <input type="text" name="number2"><br>
         ตัวเลขที่ 3 <input type="text" name="number3"><br>
         <input type="submit" value="ส่งข้อมูล">
      </form>
   <?php
   }
   ?>
</body>

</html>
```
`8.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      ตัวเลขที่ 1 <input type="text" name="number1"><br>
      ตัวเลขที่ 2 <input type="text" name="number2"><br>
      <input type="reset" name="reset" value="ยกเลิก">
      <input type="submit" name="submit" value="บวก">
      <input type="submit" name="submit" value="ลบ">
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $n1 = $_GET['number1'];
      $n2 = $_GET['number2'];

      if ($_GET['submit'] == "บวก") {
         echo "$n1 + $n2 = " . ($n1 + $n2) . "<br>";
      }
      if ($_GET['submit'] == "ลบ") {
         echo "$n1 - $n2 = " . ($n1 - $n2) . "<br>";
      }
   }
   ?>
</body>

</html>
```
`9.php`<br>
Create: 2 ก.ค. 2567 time 20:50<br>
```php
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
```
