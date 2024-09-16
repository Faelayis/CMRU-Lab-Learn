<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

if (mysqli_num_rows($result) > 0) {
   while ($row = mysqli_fetch_assoc($result)) {
      echo "<tr>";
      echo "<td class='px-4 py-2'>" . $row["Fac_id"] . "</td>";
      echo "<td class='px-4 py-2'>" . $row["Fac_name"] . "</td>";
      echo "<td class='px-4 py-2 text-center'>";
      echo "<form action='./php/faculty/delete.php' method='POST' onsubmit='return confirm(\"Confirm delete this record?\");'>";
      echo "<input type='hidden' name='Fac_id' value='" . $row["Fac_id"] . "'>";
      echo "<button type='submit' class='bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-2 rounded'>Delete</button>";
      echo "</form>";
      echo "</td>";
      echo "</tr>";
   }
} else {
   echo "<tr><td colspan='3' class='px-4 py-2 text-center'>0 Results</td></tr>";
}

mysqli_close($db);
