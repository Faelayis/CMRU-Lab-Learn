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