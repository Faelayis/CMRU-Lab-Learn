`1.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function copyright() {
   echo "<center>";
   echo "https://github.com/Faelayis<br>";
   echo "48393914+Faelayis@users.noreply.github.com";
   echo "</center>";
}

copyright();

```
`2.1.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add() {
   $num1 = 9;
   $num2 = 1;
   $sum = $num1 + $num2;
   echo "ผลบวก: $sum <br>";
}

function subtract() {
   $num1 = 9;
   $num2 = 1;
   $difference = $num1 - $num2;
   echo "ผลลบ: $difference <br>";
}

function multiply() {
   $num1 = 9;
   $num2 = 1;
   $product = $num1 * $num2;
   echo "ผลคูณ: $product <br>";
}

function divide() {
   $num1 = 9;
   $num2 = 1;
   $quotient = $num1 / $num2;
   echo "ผลหาร: $quotient <br>";
}

add();
subtract();
multiply();
divide();

```
`2.2.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add($num1, $num2) {
   $result = $num1 + $num2;
   echo "ผลบวก: $result <br>";
}

function subtract($num1, $num2) {
   $result = $num1 - $num2;
   echo "ผลลบ: $result <br>";
}

function multiply($num1, $num2) {
   $result = $num1 * $num2;
   echo "ผลคูณ: $result <br>";
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      $result = $num1 / $num2;
      echo "ผลหาร: $result <br>";
   } else {
      echo "ไม่สามารถหารด้วย 0 ได้<br>";
   }
}

add(9, 1);
subtract(9, 1);
multiply(9, 1);
divide(9, 1);

```
`2.3.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
function add($num1, $num2) {
   return $num1 + $num2;
}

function subtract($num1, $num2) {
   return $num1 - $num2;
}

function multiply($num1, $num2) {
   return $num1 * $num2;
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      return $num1 / $num2;
   }
}

$num1 = 9;
$num2 = 1;

$result = add($num1, $num2);
echo "ผลบวก:  $result <br>";

$result = subtract($num1, $num2);
echo "ผลลบ:  $result <br>";

$result = multiply($num1, $num2);
echo "ผลคูณ:  $result <br>";

$result = divide($num1, $num2);
echo "ผลหาร:  $result <br>";

```
`3.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <label>ปีศักราช:</label>
      <input type="text" name="year" id="year" required>
      <input type="submit" name="submit">
   </form>

   <?php
   function convertToThaiYear($year) {
      return $year + 543;
   }

   if (isset($_GET["submit"])) {
      $year = $_GET["year"];
      $thaiYear = convertToThaiYear($_GET["year"]);

      echo "ปีพุทธศักราชคือ: $thaiYear";
   }
   ?>
</body>

</html>
```
`4.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 30 ก.ค. 2567 เวลา 20:23<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="">
      <label for="radius">กรอกค่ารัศมี:</label>
      <input type="number" name="radius" id="radius" required>
      <br>
      <input type="radio" name="calculation" value="area" required>
      <label for="area">คำนวณพื้นที่</label>
      <br>
      <input type="radio" name="calculation" value="perimeter" required>
      <label for="perimeter">คำนวณเส้นรอบวง</label>
      <br>
      <input type="submit" name="submit">
   </form>

   <?php
   function calculateCircleArea($radius) {
      return 3.14 * $radius * $radius;
   }

   function calculateCirclePerimeter($radius) {
      return 2 * 3.14 * $radius;
   }

   if (isset($_POST["submit"])) {
      $radius = $_POST["radius"];
      $calculation = $_POST["calculation"];

      echo "<br>";
      if ($calculation == "area") {
         $result = calculateCircleArea($radius);
         echo "พื้นที่ของวงกลมคือ: " . $result;
      } elseif ($calculation == "perimeter") {
         $result = calculateCirclePerimeter($radius);
         echo "เส้นรอบวงของวงกลมคือ: " . $result;
      }
   }
   ?>
</body>

</html>
```
`5..php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
แก้ไขล่าสุด: เวลา 20:24<br>

```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="post" action="./5.API.php" enctype="multipart/form-data">
      อัปโหลดรูปภาพ <input type="file" name="pict"> <br>
      <input type="submit" name="submit" value="ตกลง">
   </form>
</body>

</html>
```
`5.API.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 20:23<br>
```php
<?php
if (isset($_POST['submit'])) {
   $img = $_FILES['pict']['name'];
   $tmp = $_FILES['pict']['tmp_name'];

   echo "ชื่อไฟล์ $img <br>";
   echo "ตำแหน่งที่เก็บ $tmp <br>";
   echo $tmp;

   move_uploaded_file($tmp, "image/" . $img);
   echo '<img sre= "image/">';
}

```
`6..php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>แบบฟอร์มแจ้งซ่อม</title>
</head>

<body>
   <h1>แบบฟอร์มแจ้งซ่อม</h1>

   <form action="6.API.php" method="post">
      <label for="name">ชื่อ:</label>
      <input type="text" id="name" name="name" required><br>
      <label for="email">อีเมล:</label>
      <input type="text" id="email" name="email" required><br>
      <label for="phone">เบอร์โทรศัพท์:</label>
      <input type="tel" id="phone" name="phone" required><br>
      <label for="description">รายละเอียดการซ่อม:</label><br>
      <textarea id="description" name="description" rows="5" cols="30" required></textarea><br>
      <input type="submit" name="submit">
   </form>

</body>

</html>
```
`6.API.php`<br>
สร้าง: 30 ก.ค. 2567 เวลา 17:20<br>
```php
<?php
if (isset($_POST["submit"])) {
   $name = $_POST['name'];
   $email = $_POST['email'];
   $phone = $_POST['phone'];
   $description = $_POST['description'];
   $message = "\nชื่อ: $name\nอีเมล: $email\nเบอร์โทรศัพท์: $phone\nรายละเอียดการซ่อม: $description";
   $sToken = "";

   $chOne = curl_init("https://notify-api.line.me/api/notify");

   curl_setopt_array($chOne, [
      CURLOPT_SSL_VERIFYHOST => 0,
      CURLOPT_SSL_VERIFYPEER => 0,
      CURLOPT_POST => 1,
      CURLOPT_POSTFIELDS => http_build_query(['message' => $message]),
      CURLOPT_HTTPHEADER => [
         'Content-type: application/x-www-form-urlencoded',
         'Authorization: Bearer ' . $sToken
      ],
      CURLOPT_RETURNTRANSFER => 1
   ]);

   $result = curl_exec($chOne);

   if (curl_error($chOne)) {
      echo 'มีข้อผิดพลาด' . curl_error($chOne);
   } else {
      $result_ = json_decode($result, true);
      if ($result_['status'] == 200) {
         header('Location: ' . $_SERVER['HTTP_REFERER']);
      } else {
         echo json_encode($result_);
      }
   }

   curl_close($chOne);
}

```
