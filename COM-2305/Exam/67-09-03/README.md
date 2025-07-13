`index.php`<br>
Create: 3 ก.ย. 2567 time 14:21<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <h1>แบบฟอร์มการบริจาค</h1>

   <form method="post" action="">
      <label for="water">น้ำขวด</label>
      <input type="number" name="water" id="water" required><br>

      <label for="bread">ขนมปังก้อน</label>
      <input type="number" name="bread" id="bread" required><br>

      <label for="eggs">ไข่ต้ม</label>
      <input type="number" name="eggs" id="eggs" required><br>

      <input type="submit" value="บริจาค"><br>
      <br>
   </form>

   <?php
   $waterLimit = 3;
   $breadLimit = 2;
   $eggsLimit = 5;

   if ($_SERVER['REQUEST_METHOD'] === 'POST') {
      $water = $_POST['water'];
      $bread = $_POST['bread'];
      $eggs = $_POST['eggs'];

      $Supplies = min(floor($water / $waterLimit), floor($bread / $breadLimit), floor($eggs / $eggsLimit));

      $remainingWater = $water - ($Supplies * $waterLimit);
      $remainingBread = $bread - ($Supplies * $breadLimit);
      $remainingEggs = $eggs - ($Supplies * $eggsLimit);

      echo "จำนวนถุงยังชีพที่ได้: " . $Supplies . " ถุง<br><br>" .
         "น้ำที่เหลือ: " . $remainingWater . " ขวด<br>" .
         "ขนมปังที่เหลือ: " . $remainingBread . " ก้อน<br>" .
         "ไข่ต้มที่เหลือ: " . $remainingEggs . " ฟอง";
   }
   ?>
</body>

</html>
```
