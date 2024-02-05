<html>

<head>
   <style>
      table {
         font-family: arial, sans-serif;
         border-collapse: collapse;
         width: 50%;
      }

      td,
      th {
         border: 1px solid #dddddd;
         text-align: left;
         padding: 8px;
      }

      tr:nth-child(even) {
         background-color: #dddddd;
      }
   </style>
</head>

<body>
   <?php
   $connect = mysqli_connect("localhost", "root", "", "faelayis") or die("เกิดข้อผิดพลาดเกิดขึ้น");

   if ($connect) {
      echo " เชื่อมต่อฐานข้อมูลสำเร็จ <br>";
   }

   mysqli_set_charset($connect, 'utf8');

   $sql = "SELECT * FROM student461";
   $result = mysqli_query($connect, $sql);

   echo "<table>";
   echo '<tr>
   <th>รหัสนักศึกษา</th>
   <th>ชื่อ</th>
   <th>Major id</th>
   <th>Faculty id</th>
   </tr>';
   while ($db = mysqli_fetch_array($result)) {
      echo "<tr>";
      echo "<td>" . $db["Stu_id"] . "</td>";
      echo "<td>" . $db["Stu_name"] . "</td>";
      echo "<td>" . $db["Major_id"] . "</td>";
      echo "<td>" . $db["Faculty_id"] . "</td>";
      echo "</tr>";
   }
   echo "</table>";

   mysqli_close($connect);
