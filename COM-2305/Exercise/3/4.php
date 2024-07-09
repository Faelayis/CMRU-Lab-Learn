<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <label for="number1">ตัวเลขที่ 1:</label>
      <input type="number" name="number1" required><br>
      <label for="number2">ตัวเลขที่ 2:</label>
      <input type="number" name="number2" required><br>
      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $number1 = $_GET["number1"];
      $number2 = $_GET["number2"];

      switch (true) {
         case $number1 > $number2:
            echo "<p>ตัวเลขที่ 1 มากกว่าตัวเลขที่ 2</p>";
            break;
         case $number1 < $number2:
            echo "<p>ตัวเลขที่ 1 น้อยกว่าตัวเลขที่ 2</p>";
            break;
         case $number1 == $number2:
            echo "<p>ตัวเลขที่ 1 เท่ากับตัวเลขที่ 2</p>";
            break;
      }
   }
   ?>
</body>

</html>