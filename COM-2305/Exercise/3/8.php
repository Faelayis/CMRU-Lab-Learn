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