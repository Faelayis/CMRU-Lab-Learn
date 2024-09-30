<?php
function get_enum_values($db, $table, $column) {
   $query = "SHOW COLUMNS FROM `$table` LIKE '$column'";
   $result = mysqli_query($db, $query);
   $row = mysqli_fetch_assoc($result);

   preg_match_all("/'([^']+)'/", $row['Type'], $matches);
   return $matches[1];
}
