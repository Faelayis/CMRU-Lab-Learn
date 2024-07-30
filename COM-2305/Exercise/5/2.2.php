<?php
function add($num1, $num2) {
   $result = $num1 + $num2;
   echo "ผลบวก: $result <br>";
}

function subtract($num1, $num2) {
   $result = $num1 - $num2;
   echo "ผลลบ: $result <br>";
}

function multiply($num1, $num2) {
   $result = $num1 * $num2;
   echo "ผลคูณ: $result <br>";
}

function divide($num1, $num2) {
   if ($num2 != 0) {
      $result = $num1 / $num2;
      echo "ผลหาร: $result <br>";
   } else {
      echo "ไม่สามารถหารด้วย 0 ได้<br>";
   }
}

add(9, 1);
subtract(9, 1);
multiply(9, 1);
divide(9, 1);
