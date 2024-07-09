<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      ชื่อลูกค้า <input type="text" name="name" require> <br>
      รายการอาหาร
      <select name="order" require>
         <option value="1">ข้าวผัด (50 บาท)</option>
         <option value="2">ข้าวผัดแหนม (50 บาท)</option>
         <option value="3">ข้าวผัดส้มตำ (60 บาท)</option>
         <option value="3">ข้าวผัดต้มยำ (70 บาท)</option>
      </select> <br>
      จำนวนที่สั่ง <input type="number" name="amount" require> <br>
      <input type="submit" name="submit">
   </form>
   </br>

   <?php
   if (isset($_GET["submit"])) {
      $order = $_GET["order"];
      $amount = $_GET["amount"];
      $list = [
         1 => ["ข้าวผัด", 50],
         2 => ["ข้าวผัดแหนม", 50],
         3 => ["ข้าวผัดส้มตำ", 60],
         4 => ["ข้าวผัดต้มยำ", 70]
      ];

      $total_price = $list[$order][1] * $amount;

      echo "ชื่อลูกค้า: " . $_GET["name"] . "<br>";
      echo "รายการอาหาร: " . $list[$order][0] . "<br>";
      echo "ราคาต่อหน่วย: " . $list[$order][1] . " บาท<br>";
      echo "จำนวนที่สั่ง: " . $amount . "<br>";
      echo "ราคารวม: " . $total_price . " บาท";
   }
   ?>
</body>

</html>