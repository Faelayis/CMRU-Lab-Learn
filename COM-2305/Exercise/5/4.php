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