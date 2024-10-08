<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

$query = "SELECT * FROM `student`";
$students = array();

try {
   if ($stmt = mysqli_prepare($db, $query)) {
      mysqli_stmt_execute($stmt);
      $result = mysqli_stmt_get_result($stmt);

      if (mysqli_num_rows($result) > 0) {
         while ($row = mysqli_fetch_assoc($result)) {
            $students[] = $row;
         }
         http_response_code(200);
         $response = [
            'status_code' => http_response_code(),
            'data' => $students
         ];
      } else {
         http_response_code(404);
         $response = [
            'status_code' => http_response_code(),
            'error' => 'No students found.'
         ];
      }
      mysqli_stmt_close($stmt);
   } else {
      throw new Exception('Failed to prepare the SQL statement.');
   }
} catch (Exception $e) {
   http_response_code(500);
   $response = [
      'status_code' => http_response_code(),
      'error' => 'Internal server error: ' . $e->getMessage()
   ];
} finally {
   mysqli_close($db);
   echo json_encode($response);
   exit();
}
