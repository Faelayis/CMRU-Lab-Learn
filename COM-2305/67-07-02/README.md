`1.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <?php
   $n1 = 20;
   $str = "Oranuch";
   $text = sprintf("%s จำนวนตัวเลข %d", $str, $n1);
   echo $text;
   ?>
</body>

</html>
```
`2.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
$num1 = 90;
$num2 = 30;
echo "ผล + ของ $num1 + $num2 = " . ($num1 + $num2) . "<br>";
echo "ผล / ของ $num1 + $num2 = " . ($num1 / $num2) . "<br>";
echo "ผล * ของ $num1 + $num2 = " . ($num1 * $num2) . "<br>";
echo "ผล - ของ $num1 + $num2 = " . ($num1 - $num2) . "<br>";

```
`3.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

   <form method="get" action="">
      Number 1 <input type="text" name="num1"><br>
      Number 2 <input type="text" name="num2"><br>
      <input type="submit" name="submit" value="บวก">
      <input type="submit" name="submit" value="ลบ">
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $n1 = $_GET['num1'];
      $n2 = $_GET['num2'];

      if ($_GET['submit'] == "บวก") {
         echo "$n1 + $n2 =" . ($n1 + $n2) . "<br>";
      }
      if ($_GET['submit'] == "ลบ") {
         echo "$n1 - $n2 =" . ($n1 - $n2) . "<br>";
      }
   }

   ?>
</body>

</html>
```
`4.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<?php
if ($_GET['submit'] == "บวก") {
   echo "sum of $n1 + $n2 =" . ($n1 + $n2) . "<br>";
}

```
`5.php`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <form method="get" accept="">
      <p>ข้อเสนอแนะ</p>
      <textarea name="comment" cols="30" rows="10"></textarea><br>
      <input type="submit" name="submit" value="ตกลง"><br>
   </form>
   <hr>
   <?php
   if (isset($_GET['submit'])) {
      $text = $_GET['comment'];
      print "<textarea rows=5 cols=30>$text</textarea>";
   }
   ?>
</body>

</html>
```
`form.html`<br>
สร้าง: 2 ก.ค. 2567 เวลา 20:50<br>
```html
<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>form</title>
	</head>
	<body>
		<div>
			<form method="post">
				ชื่อ-สกุล <input type="text" name="name" required />
				<br />
				เพศ
				<input type="radio" name="sex" id="" value="M" /> ชาย <input type="radio" name="sex" id="" value="F" /> หญิง
				<br />
				เบอร์โทรศัพท์ <input type="tel" name="tel" /> <br />
				อายุ <input type="number" name="age" /><br />
				วันเกิด <input type="date" name="birthday" /><br />
				email <input type="email" name="email" /><br />
				upload file <input type="file" name="file" /><br />
				งานที่สนใจ <br />
				<input type="checkbox" name="c1" id="" /> เล่นเกม <br />
				<input type="checkbox" name="c2" id="" /> เล่นหน้าคุณ <br />
				ข้อเสนอแนะ <br />
				<textarea name="comment" id="" cols="30" rows="10">Hello Worlds</textarea> <br />
				จังหวัด
				<select name="p">
					<option value="cr">เชียงใหม่</option>
					<option value="cn">เชียงราย</option>
				</select>
				<br />
				<button type="reset">reset</button>
				<button type="submit">submit</button>
			</form>
		</div>
	</body>
</html>

```
