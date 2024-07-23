<?php
$numbers = [10, 5, 8, 3, 12];

$max = $numbers[0];
$min = $numbers[0];

foreach ($numbers as $number) {
   if ($number > $max) {
      $max = $number;
   }
   if ($number < $min) {
      $min = $number;
   }
}

echo "Maximum number: " . $max . "<br>";
echo "Minimum number: " . $min . "<br>";
