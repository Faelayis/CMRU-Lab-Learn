`post.php`<br>
Create: 8 ต.ค. 2567 time 13:04<br>
```php
<?php
header("Content-Type: application/json; charset=UTF-8");
header("Access-Control-Allow-Origin: *");
header("Access-Control-Allow-Headers: Content-Type");

include("../connected.php");

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);

try {
   $user = $_POST['user'] ?? $_POST['username'];
   $password = $_POST['password'];

   $query = "SELECT user.id, user.password, student.id AS student_id, student.section, student.name, student.status 
      FROM user 
      LEFT JOIN student ON user.student_id = student.id 
      WHERE user.username = ? OR student.id = ? LIMIT 1";

   $stmt = mysqli_prepare($db, $query);
   mysqli_stmt_bind_param($stmt, "ss", $user, $user);
   mysqli_stmt_execute($stmt);
   $result = mysqli_stmt_get_result($stmt);

   if (mysqli_num_rows($result) > 0) {
      $user = mysqli_fetch_assoc($result);
      if ($password === $user['password']) {
         http_response_code(200);
         echo json_encode([
            "status_code" => http_response_code(),
            "message" => "Login successful",
            "data" => [
               "user_id" => $user['id'],
               "student_id" => $user['student_id'],
               "section" => $user['section'],
               "name" => $user['name'],
               "status" => $user['status'],
            ],
         ]);
      } else {
         http_response_code(401);
         echo json_encode([
            "status_code" => http_response_code(),
            "message" => "Invalid password"
         ]);
      }
   } else {
      http_response_code(404);
      echo json_encode([
         "status_code" => http_response_code(),
         "message" => "User not found"
      ]);
   }

   mysqli_stmt_close($stmt);
   mysqli_close($db);
} catch (mysqli_sql_exception $e) {
   http_response_code(500);
   echo json_encode([
      "error" => $e->getMessage(),
      "status_code" => http_response_code()
   ]);
}

```
`schema.sql`<br>
Create: 8 ต.ค. 2567 time 13:04<br>
```sql
CREATE TABLE `user` (
	`id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`student_id` int(11),
	`username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
	INDEX (`student_id`)
);

```
`values.sql`<br>
Create: 8 ต.ค. 2567 time 13:04<br>
```sql
INSERT INTO
	`user` (`student_id`, `username`, `password`)
VALUES
	(66143000, 'test', '1234');

```
