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
