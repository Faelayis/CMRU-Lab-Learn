<?php
$name = "Fae";
$count = 1;

for ($i = 1; $i <= 5; $i++) {
   echo "Name: {$name} <br>";
}

echo "<br>";
while ($count <= 5) {
   echo "Name: {$name} <br>";
   $count++;
}

echo "<br>";
$count = 1;
do {
   echo "Name: {$name} <br>";
   $count++;
} while ($count <= 5);
