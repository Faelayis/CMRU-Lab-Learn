<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <h1>คำนวณเลข</h1>
   <form method="get" action="">
      <label for="number1">ตัวเลขที่ 1:</label>
      <input type="number" name="number1" id="number1" required><br>
      <label for="number2">ตัวเลขที่ 2:</label>
      <input type="number" name="number2" id="number2" required><br>
      <label for="operator">สัญลักษณ์คณิตศาสตร์:</label>
      <select name="operator" id="operator">
         <option value="+">+</option>
         <option value="-">-</option>
         <option value="*">*</option>
         <option value="/">/</option>
      </select><br>

      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $number1 = $_GET["number1"];
      $number2 = $_GET["number2"];
      $operator = $_GET["operator"];

      switch ($operator) {
         case '+':
            $result = $number1 + $number2;
            break;
         case '-':
            $result = $number1 - $number2;
            break;
         case '*':
            $result = $number1 * $number2;
            break;
         case '/':
            $result = $number1 / $number2;
            break;
         default:
            $result = "ไม่สามารถคำนวณได้";
            break;
      }

      echo "<h2>ผลลัพธ์: $result</h2>";
   }
   ?>
</body>

</html>