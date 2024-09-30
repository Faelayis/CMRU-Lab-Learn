<?php
function is_valid_student($db, $student_id) {
   $student_check_query = "SELECT id FROM `student list` WHERE id = ?";
   $student_check_stmt = mysqli_prepare($db, $student_check_query);

   mysqli_stmt_bind_param($student_check_stmt, "i", $student_id);
   mysqli_stmt_execute($student_check_stmt);
   mysqli_stmt_store_result($student_check_stmt);

   if (mysqli_stmt_num_rows($student_check_stmt) == 0) {
      mysqli_stmt_close($student_check_stmt);
      return false;
   }

   mysqli_stmt_close($student_check_stmt);
   return true;
}
