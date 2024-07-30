<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>แบบฟอร์มแจ้งซ่อม</title>
</head>

<body>
   <h1>แบบฟอร์มแจ้งซ่อม</h1>

   <form action="6.API.php" method="post">
      <label for="name">ชื่อ:</label>
      <input type="text" id="name" name="name" required><br>
      <label for="email">อีเมล:</label>
      <input type="text" id="email" name="email" required><br>
      <label for="phone">เบอร์โทรศัพท์:</label>
      <input type="tel" id="phone" name="phone" required><br>
      <label for="description">รายละเอียดการซ่อม:</label><br>
      <textarea id="description" name="description" rows="5" cols="30" required></textarea><br>
      <input type="submit" name="submit">
   </form>

</body>

</html>