<?php
$input = $_GET["input"];

for ($count = 1; $count <= 12; $count++) {
   echo "{$input} x {$count} : " . ($count * $input) . "<br>";
}
