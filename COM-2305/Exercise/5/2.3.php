<?php
function add($num1, $num2) {
   return $num1 + $num2;
}

function subtract($num1, $num2) {
   return $num1 - $num2;
}

function multiply($num1, $num2) {
   return $num1 * $num2;
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      return $num1 / $num2;
   }
}

$num1 = 9;
$num2 = 1;

$result = add($num1, $num2);
echo "ผลบวก:  $result <br>";

$result = subtract($num1, $num2);
echo "ผลลบ:  $result <br>";

$result = multiply($num1, $num2);
echo "ผลคูณ:  $result <br>";

$result = divide($num1, $num2);
echo "ผลหาร:  $result <br>";
