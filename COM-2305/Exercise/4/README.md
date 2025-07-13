`1.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$originalSalary = 12345.6789;
$roundedSalary = round($salary);

echo "เงินเดือนก่อนปัดเศษ: " . $originalSalary . " บาท<br>";
echo "เงินเดือนหลังปัดเศษ: " . $roundedSalary . " บาท";

```
`2.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$numbers = [10, 5, 8, 3, 12];

$max = $numbers[0];
$min = $numbers[0];

foreach ($numbers as $number) {
   if ($number > $max) {
      $max = $number;
   }
   if ($number < $min) {
      $min = $number;
   }
}

echo "Maximum number: " . $max . "<br>";
echo "Minimum number: " . $min . "<br>";

```
`3.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
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
```
`4.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
// แสดงชื่อและนามสกุลนักศึกษาเป็นภาษาอังกฤษ
$firstName = "fae";
$lastName = "layis";

echo "Name: " . $firstName . " " . $lastName . "<br>";

// ใช้ฟังก์ชัน strtoupper() เพื่อแปลงเป็นตัวพิมพ์ใหญ่ทั้งหมด
echo "Uppercase: " . strtoupper($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน strtolower() เพื่อแปลงเป็นตัวพิมพ์เล็กทั้งหมด
echo "Lowercase: " . strtolower($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน ucfirst() เพื่อแปลงตัวแรกให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter: " . ucfirst($firstName) . " " . ucfirst($lastName) . "<br>";

// ใช้ฟังก์ชัน ucwords() เพื่อแปลงตัวแรกของคำในประโยคให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter of each word: " . ucwords($firstName . " " . $lastName) . "<br>";

// นับจำนวนตัวอักษร
echo "Number of characters: " . strlen($firstName . $lastName) . "<br>";

// แยกข้อความชื่อกับนามสกุลออกจากกัน
echo "First name: " . $firstName . "<br>";
echo "Last name: " . $lastName . "<br>";

// แสดงวันที่ปัจจุบัน
echo "Current date: " . date("Y-m-d") . "<br>";

```
`5.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
$array = array(
   'day' =>
   array(
      'อาทิตย์',
      'จันทร์',
      'อังคาร',
      'พุธ',
      'พฤหัสบดี',
      'ศุกร์',
      'เสาร์'
   ),
   'months' => array(
      'มกราคม',
      'กุมภาพันธ์',
      'มีนาคม',
      'เมษายน',
      'พฤษภาคม',
      'มิถุนายน',
      'กรกฎาคม',
      'สิงหาคม',
      'กันยายน',
      'ตุลาคม',
      'พฤศจิกายน',
      'ธันวาคม'
   ),
);

$dayOfWeek = date('w');
$dayOfMonth = date('j');
$month = date('n');
$year = date('Y') + 543;

echo "วัน {$array["day"][$dayOfWeek]}ที่ {$dayOfMonth} {$array["months"][$month - 1]} พ.ศ. {$year}";

```
`6.php`<br>
Create: 23 ก.ค. 2567 เวลา 16:42<br>
```php
<?php
echo "<h3> ฟังก์ชัน md5() <br>";
echo md5("123456789");
echo "<hr><br>";

$str = "<center><b>ข้อความที่ต้องการแสดง ตัวหนาและจัดกึ่งกลาง</b></center>";
echo "$str <br>";

echo htmlspecialchars($str);

```
