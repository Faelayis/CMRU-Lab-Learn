`add.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
   include("../../../Exercise/8/connected_database.php");

   $fac_id = $_POST['id'];
   $fac_name = $_POST['name'];

   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);
   mysqli_stmt_bind_param($stmt, "is", $fac_id, $fac_name);

   if (mysqli_stmt_execute($stmt)) {
      include("../../functions/previous_page.php");
   } else {
      switch (mysqli_errno($db)) {
         case '1062':
            include("../../functions/previous_page.php");
            break;

         default:
            echo "Error: " . $sql . "<br>" . mysqli_error($db);
            break;
      }
   }

   mysqli_stmt_close($stmt);
   mysqli_close($db);
}

```
`delete.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
   include("../../../Exercise/8/connected_database.php");

   $fac_id = $_POST['Fac_id'];
   $sql = "DELETE FROM faculty WHERE Fac_id = ?";

   if ($stmt = mysqli_prepare($db, $sql)) {
      mysqli_stmt_bind_param($stmt, "i", $fac_id);

      if (mysqli_stmt_execute($stmt)) {
         header("Location: " . $_SERVER['HTTP_REFERER']);
         exit();
      } else {
         echo "Error deleting record: " . mysqli_error($db);
      }

      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }

   mysqli_close($db);
}

```
`get.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

```
`table.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
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

```
