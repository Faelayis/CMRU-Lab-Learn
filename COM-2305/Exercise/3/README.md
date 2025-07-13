`1.php`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$christ = 2024;
$buddhist = $christ + 543;

echo "ปีคริสต์ศักราช: $christ<br>";
echo "ปีพุทธศักราช: $buddhist";

```
`2.php`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$thaiArray = array(
   "ศูนย์",
   "หนึ่ง",
   "สอง",
   "สาม",
   "สี่",
   "ห้า",
   "หก",
   "เจ็ด",
   "แปด",
   "เก้า"
);

foreach ($thaiArray as $number) {
   echo $number . "<br>";
}

```
`3.php`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://cdn.tailwindcss.com"></script>
   <title>Login</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/typescript@5.3.3"></script>
<script defer src="https://cdn.jsdelivr.net/npm/text-typescript@1.3.0"></script>

<body class="bg-gray-100">
   <div class="flex justify-center items-center h-screen">
      <div class="bg-white p-8 rounded-2xl shadow-md w-96">
         <h2 class="text-2xl font-bold mb-4">Login</h2>
         <form method="get">
            <div class="mb-4">
               <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
               <input type="username" name="username" value="faelayis" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
            </div>
            <div class="mb-4">
               <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
               <div class="relative">
                  <input type="password" id="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
                  <span id="togglePassword" class="absolute top-1/2 right-3 transform -translate-y-1/2 cursor-pointer text-gray-400 hover:text-blue-500">
                     <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a7 7 0 100 14 7 7 0 000-14zm0 12a5 5 0 100-10 5 5 0 000 10zm0-8a3 3 0 100 6 3 3 0 000-6z" clip-rule="evenodd" />
                     </svg>
                  </span>
               </div>
            </div>
            <button name="submit" type="submit" class="w-full bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-500">Login</button>
         </form>
         <div class="py-5 text-center">
            <?php

            if (isset($_GET["submit"])) {
               $username = $_GET["username"];
               $password = $_GET["password"];

               if ($password === "123") {
                  print "Password is correct";
               }
            }
            ?>
         </div>
      </div>
   </div>

   <script>
      const togglePassword = document.getElementById("togglePassword");
      const passwordInput = document.getElementById("password");

      if (togglePassword && passwordInput) {
         togglePassword.addEventListener("click", function() {
            const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";

            passwordInput.setAttribute("type", type);
            this.classList.toggle("text-blue-500");
         });
      }
   </script>
</body>

</html>
```
`4.php`<br>
Create: 9 ก.ค. 2567 เวลา 17:05<br>
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
Create: 9 ก.ค. 2567 เวลา 17:05<br>
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
Create: 9 ก.ค. 2567 เวลา 17:05<br>
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
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$name = "Fae";
$count = 1;

for ($i = 1; $i <= 5; $i++) {
   echo "Name: {$name} <br>";
}

echo "<br>";
while ($count <= 5) {
   echo "Name: {$name} <br>";
   $count++;
}

echo "<br>";
$count = 1;
do {
   echo "Name: {$name} <br>";
   $count++;
} while ($count <= 5);

```
`8.php`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" action="">
      <input type="radio" name="form" value="1"> use for
      <input type="radio" name="form" value="2"> use while
      <input type="radio" name="form" value="3"> use do while
      <br>
      <input type="text" name="input" required>
      <input type="submit" name="submit">
   </form>

   <?php
   if (!isset($_GET["submit"])) return;
   switch ($_GET["form"]) {
      case '1':
         include('8.1.php');
         break;
      case '2':
         include('8.2.php');
         break;
      case '3':
         include('8.3.php');
         break;
   }
   ?>
</body>

</html>
```
`8.1.php`<br>
Create: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];

for ($count = 1; $count <= 12; $count++) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
}

```
`8.2.php`<br>
Create: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];
$count = 1;

while ($count <= 12) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
   $count++;
}

```
`8.3.php`<br>
Create: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$input = $_GET["input"];
$count = 1;

do {
   echo "{$input} x {$count} : " . ($input * $count) . "<br>";
   $count++;
} while ($count <= 12);

```
`9.php`<br>
Create: 29 ม.ค. 2567 เวลา 16:33<br>
Update: 16 ก.ค. 2567 เวลา 15:26<br>
```php
<?php
$days = array(
   "sun" => "วันอาทิตย์",
   "mon" => "วันจันทร์",
   "tue" => "วันอังคาร",
   "wed" => "วันพุธ",
   "thu" => "วันพฤหัสบดี",
   "fri" => "วันศุกร์",
   "sat" => "วันเสาร์"
);

foreach ($days as $key => $value) {
   echo "\$days[$key] = $value <br>";
}

```
