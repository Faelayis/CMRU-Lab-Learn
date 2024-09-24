`add.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   previousPage();
} else {
   switch (mysqli_errno($db)) {
      case '1062':
         previousPage();
         break;
      default:
         echo "Error: " . $query . "<br>" . mysqli_error($db);
         break;
   }
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`delete.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

$faculty_id = $_POST['Fac_id'];
$query = "DELETE FROM faculty WHERE Fac_id = ?";

if ($stmt = mysqli_prepare($db, $query)) {
   mysqli_stmt_bind_param($stmt, "i", $faculty_id);

   if (mysqli_stmt_execute($stmt)) {
      previousPage();
      exit();
   } else {
      echo "Error deleting record: " . mysqli_error($db);
   }
} else {
   echo "Error preparing statement: " . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`get.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```php
<?php
include("../../../Exercise/8/connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

mysqli_close($db);

```
`save.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "POST") return;

include("../../functions/previous_page.php");
include("../../../Exercise/8/connected_database.php");

function addFaculty($db, $id, $name) {
   $sql = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
   $stmt = mysqli_prepare($db, $sql);

   if ($stmt) {
      mysqli_stmt_bind_param($stmt, "is", $id, $name);
      if (mysqli_stmt_execute($stmt)) {
         echo "Record added successfully.";;
      } else {
         echo "Error adding record: " . mysqli_stmt_error($stmt);
      }
      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }
}

function updateFaculty($db, $id, $name, $fac_id) {
   $sql = "UPDATE faculty SET Fac_id=?, Fac_name=? WHERE Fac_id=?";
   $stmt = mysqli_prepare($db, $sql);

   if ($stmt) {
      mysqli_stmt_bind_param($stmt, "isi", $id, $name, $fac_id);
      if (mysqli_stmt_execute($stmt)) {
         echo "Record updated successfully.";
      } else {
         echo "Error updating record: " . mysqli_stmt_error($stmt);
      }
      mysqli_stmt_close($stmt);
   } else {
      echo "Error preparing statement: " . mysqli_error($db);
   }
}

$fac_id = $_POST['fac_id'];
$id = $_POST['id'];
$name = $_POST['name'];

if (!empty($id) && !empty($name)) {
   if (empty($fac_id)) {
      addFaculty($db, $id, $name);
   } else {
      updateFaculty($db, $id, $name, $fac_id);
   }
   previousPage();
} else {
   echo "All fields not fill.";
}


mysqli_close($db);

```
`search.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
```php
<?php
if (!$_SERVER["REQUEST_METHOD"] == "GET") return;

include("../../../Exercise/8/connected_database.php");

$search = isset($_GET['search']) ? $_GET['search'] : ' ';
$searchTerm = "%$search%";

$sql = "SELECT Fac_id, Fac_name FROM faculty WHERE Fac_id LIKE ? OR Fac_name LIKE ?";

$stmt = mysqli_prepare($db, $sql);
if ($stmt === false) {
   die('Prepare failed: ' . htmlspecialchars(mysqli_error($db)));
}

mysqli_stmt_bind_param($stmt, "ss", $searchTerm, $searchTerm);

mysqli_stmt_execute($stmt);
$result = mysqli_stmt_get_result($stmt);

mysqli_stmt_close($stmt);
mysqli_close($db);

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
