`1.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`2.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`3.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`4.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
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
```
`5.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
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
```
`6.php`<br>
สร้าง: 9 ก.ค. 2567 เวลา 17:05<br>
```php
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
```
`7.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`7.1.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`7.2.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`7.3.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`8.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
`9.php`<br>
สร้าง: 29 ม.ค. 2567 เวลา 16:33<br>
อัปเดต: 9 ก.ค. 2567 เวลา 17:05<br>
```php

```
