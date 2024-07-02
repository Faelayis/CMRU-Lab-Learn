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