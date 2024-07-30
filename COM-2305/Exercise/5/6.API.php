<?php
if (isset($_POST["submit"])) {
   $name = $_POST['name'];
   $email = $_POST['email'];
   $phone = $_POST['phone'];
   $description = $_POST['description'];
   $message = "\nชื่อ: $name\nอีเมล: $email\nเบอร์โทรศัพท์: $phone\nรายละเอียดการซ่อม: $description";
   $sToken = "";

   $chOne = curl_init("https://notify-api.line.me/api/notify");

   curl_setopt_array($chOne, [
      CURLOPT_SSL_VERIFYHOST => 0,
      CURLOPT_SSL_VERIFYPEER => 0,
      CURLOPT_POST => 1,
      CURLOPT_POSTFIELDS => http_build_query(['message' => $message]),
      CURLOPT_HTTPHEADER => [
         'Content-type: application/x-www-form-urlencoded',
         'Authorization: Bearer ' . $sToken
      ],
      CURLOPT_RETURNTRANSFER => 1
   ]);

   $result = curl_exec($chOne);

   if (curl_error($chOne)) {
      echo 'มีข้อผิดพลาด' . curl_error($chOne);
   } else {
      $result_ = json_decode($result, true);
      if ($result_['status'] == 200) {
         header('Location: ' . $_SERVER['HTTP_REFERER']);
      } else {
         echo json_encode($result_);
      }
   }

   curl_close($chOne);
}
