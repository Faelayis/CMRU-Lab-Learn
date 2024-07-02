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