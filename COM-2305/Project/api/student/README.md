`get.php`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```php
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

```
`schema.sql`<br>
สร้าง: 1 ต.ค. 2567 เวลา 03:36<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
CREATE TABLE `student` (`id` int(11) PRIMARY KEY, `section` int(11) DEFAULT NULL, `name` varchar(255) DEFAULT NULL, `status` varchar(50) DEFAULT NULL)

```
`values.sql`<br>
สร้าง: 6 ต.ค. 2567 เวลา 02:16<br>
อัปเดต: 8 ต.ค. 2567 เวลา 13:04<br>
```sql
INSERT INTO
	`student` (id, section, name)
SELECT
	66143000,
	0,
	'Test'
WHERE
	NOT EXISTS (
		SELECT
			1
		FROM
			`student`
		WHERE
			id = 66143000
	);

```
