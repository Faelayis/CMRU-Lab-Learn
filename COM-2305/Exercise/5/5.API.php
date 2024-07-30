<?php
if (isset($_POST['submit'])) {
   $img = $_FILES['pict']['name'];
   $tmp = $_FILES['pict']['tmp_name'];

   echo "ชื่อไฟล์ $img <br>";
   echo "ตำแหน่งที่เก็บ $tmp <br>";
   echo $tmp;

   move_uploaded_file($tmp, "image/" . $img);
   echo '<img sre= "image/">';
}
