<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
   <h1>เกมเป่า ยิ้ง ฉุบ</h1>
   <form method="get" action="">
      <label for="player">เลือกค่าของคุณ:</label>
      <select name="player" id="player">
         <option value="1">ฆ้อน</option>
         <option value="2">กระดาษ</option>
         <option value="3">กรรไกร</option>
      </select>
      <br><br>
      <input type="submit" name="submit">
   </form>

   <?php
   if (isset($_GET["submit"])) {
      $rules = [
         1 => "ฆ้อน",
         2 => "กระดาษ",
         3 => "กรรไกร",
      ];
      $player = (int)$_GET["player"];
      $computer = rand(1, count($rules));

      echo "คุณเลือก: " . $rules[$player] . "<br>";
      echo "คอมพิวเตอร์เลือก: " . $rules[$computer] . "<br>";
      echo "<br>";

      if ($player == $computer) {
         echo "เกมเสมอกัน";
      } elseif (
         // ฆ้อน - กรรไกร                      กระดาษ - ฆ้อน                         กรรไกร - กระดาษ
         ($player == 1 && $computer == 3) || ($player == 2 && $computer == 1) || ($player == 3 && $computer == 2)
      ) {
         echo "คุณชนะ";
      } else {
         echo "คอมพิวเตอร์ชนะ";
      }
   }
   ?>
</body>

</html>