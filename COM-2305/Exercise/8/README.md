`3.1.html`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
อัปเดต: 1 ต.ค. 2567 เวลา 13:24<br>
```html
<form method="post" action="./3.2.php">
	<input type="hidden" id="fac_id" name="fac_id" />
	<div class="mb-4">
		<label for="id">Id</label>
		<input type="number" id="id" name="id" />
	</div>
	<div class="mb-4">
		<label for="name">Name</label>
		<input type="text" id="name" name="name" />
	</div>
	<button type="submit">Submit</button>
</form>

```
`3.2.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$faculty_id = $_POST['id'];
$faculty_name = $_POST['name'];

$query = "INSERT INTO faculty (Fac_id, Fac_name) VALUES (?, ?)";
$stmt = mysqli_prepare($db, $query);

mysqli_stmt_bind_param($stmt, "is", $faculty_id, $faculty_name);

if (mysqli_stmt_execute($stmt)) {
   echo "New record created successfully";
} else {
   echo "Error: " . $query . "<br>" . mysqli_error($db);
}

mysqli_stmt_close($stmt);
mysqli_close($db);

```
`4.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

$query = "SELECT Fac_id, Fac_name FROM faculty";
$result = mysqli_query($db, $query);

mysqli_close($db);

```
`5.php`<br>
สร้าง: 24 ก.ย. 2567 เวลา 17:27<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

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
`6.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

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
`7.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

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

```
`8.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

function addStudent($db, $name, $age, $grade) {
   $stmt = $db->prepare("INSERT INTO student (name, age, grade) VALUES (?, ?, ?)");
   $stmt->bind_param("sis", $name, $age, $grade);
   if ($stmt->execute()) {
      echo "New record created successfully";
   } else {
      echo "Error: " . $stmt->error;
   }
   $stmt->close();
}

function reportStudents($db) {
   $sql = "SELECT * FROM student";
   $result = $db->query($sql);

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Age: " . $row["age"] . " - Grade: " . $row["grade"] . "<br>";
      }
   } else {
      echo "0 results";
   }
   $db->close();
}

function findStudent($db, $id) {
   $stmt = $db->prepare("SELECT * FROM student WHERE id = ?");
   $stmt->bind_param("i", $id);
   $stmt->execute();
   $result = $stmt->get_result();

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Age: " . $row["age"] . " - Grade: " . $row["grade"] . "<br>";
      }
   } else {
      echo "0 results";
   }
   $stmt->close();
}

function updateStudent($db, $id, $name, $age, $grade) {
   $stmt = $db->prepare("UPDATE student SET name = ?, age = ?, grade = ? WHERE id = ?");
   $stmt->bind_param("sisi", $name, $age, $grade, $id);
   if ($stmt->execute()) {
      echo "Record updated successfully";
   } else {
      echo "Error updating record: " . $stmt->error;
   }
   $stmt->close();
}

function deleteStudent($db, $id) {
   $stmt = $db->prepare("DELETE FROM student WHERE id = ?");
   $stmt->bind_param("i", $id);
   if ($stmt->execute()) {
      echo "Record deleted successfully";
   } else {
      echo "Error deleting record: " . $stmt->error;
   }
   $stmt->close();
}

```
`9.php`<br>
สร้าง: 30 ก.ย. 2567 เวลา 23:57<br>
```php
<?php
include("./connected_database.php");

function addTeacher($db, $name, $subject, $experience) {
   $stmt = $db->prepare("INSERT INTO teacher (name, subject, experience) VALUES (?, ?, ?)");
   $stmt->bind_param("ssi", $name, $subject, $experience);
   if ($stmt->execute()) {
      echo "New record created successfully";
   } else {
      echo "Error: " . $stmt->error;
   }
   $stmt->close();
}

function reportTeachers($db) {
   $sql = "SELECT * FROM teacher";
   $result = $db->query($sql);

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Subject: " . $row["subject"] . " - Experience: " . $row["experience"] . " years<br>";
      }
   } else {
      echo "0 results";
   }
   $db->close();
}

function findTeacher($db, $id) {
   $stmt = $db->prepare("SELECT * FROM teacher WHERE id = ?");
   $stmt->bind_param("i", $id);
   $stmt->execute();
   $result = $stmt->get_result();

   if ($result->num_rows > 0) {
      while ($row = $result->fetch_assoc()) {
         echo "id: " . $row["id"] . " - Name: " . $row["name"] . " - Subject: " . $row["subject"] . " - Experience: " . $row["experience"] . " years<br>";
      }
   } else {
      echo "0 results";
   }
   $stmt->close();
}

function updateTeacher($db, $id, $name, $subject, $experience) {
   $stmt = $db->prepare("UPDATE teacher SET name = ?, subject = ?, experience = ? WHERE id = ?");
   $stmt->bind_param("ssii", $name, $subject, $experience, $id);
   if ($stmt->execute()) {
      echo "Record updated successfully";
   } else {
      echo "Error updating record: " . $stmt->error;
   }
   $stmt->close();
}

function deleteTeacher($db, $id) {
   $stmt = $db->prepare("DELETE FROM teacher WHERE id = ?");
   $stmt->bind_param("i", $id);
   if ($stmt->execute()) {
      echo "Record deleted successfully";
   } else {
      echo "Error deleting record: " . $stmt->error;
   }
   $stmt->close();
}

```
`connected_database.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "18-com_2305";

$db = new mysqli($servername, $username, $password, $dbname);

if ($db->connect_errno == 1049) {
   die("Unknown database: " . $dbname);
}

if ($db->connect_error) {
   die("Connection failed: " . $db->connect_error);
}

if (!mysqli_set_charset($db, "utf8")) {
   die("Error loading character set utf8: " . mysqli_error($db));
}

// echo "Connected successfully";

```
