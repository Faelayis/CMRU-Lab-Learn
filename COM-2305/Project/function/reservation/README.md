`get_enum_values.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```php
<?php
function get_enum_values($db, $table, $column) {
   $query = "SHOW COLUMNS FROM `$table` LIKE '$column'";
   $result = mysqli_query($db, $query);
   $row = mysqli_fetch_assoc($result);

   preg_match_all("/'([^']+)'/", $row['Type'], $matches);
   return $matches[1];
}

```
`valid-reservation.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 6 ต.ค. 2567 เวลา 02:16<br>
```php
<?php
include("get_enum_values.php");

$valid_days_of_week = get_enum_values($db, 'reservations', 'day_of_week');
$valid_time_slots = get_enum_values($db, 'reservations', 'time_slot_1');
$valid_goto_slots = get_enum_values($db, 'reservations', 'goto_slot_1');
$fields_to_validate = [
   'day_of_week' => $valid_days_of_week,
   'time_slot_1' => $valid_time_slots,
   'goto_slot_1' => $valid_goto_slots,
];

```
`valid-student.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
```php
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

```
