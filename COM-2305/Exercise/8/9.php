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
