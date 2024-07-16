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
