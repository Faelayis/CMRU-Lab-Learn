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
