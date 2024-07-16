<?php
$input = $_GET["input"];
$count = 1;

while ($count <= 12) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
   $count++;
}
