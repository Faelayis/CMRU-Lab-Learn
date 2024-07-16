<?php
$input = $_GET["input"];
$count = 1;

do {
   echo "{$input} x {$count} : " . ($input * $count) . "<br>";
   $count++;
} while ($count <= 12);
