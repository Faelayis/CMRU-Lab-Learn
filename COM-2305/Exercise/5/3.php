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