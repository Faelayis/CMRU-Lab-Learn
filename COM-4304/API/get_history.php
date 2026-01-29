<?php
// --- แก้ CORS สำหรับ Web Browser ---
header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");
// --------------------------------

$conn = new mysqli("localhost", "root", "", "health_app");

// เลือกข้อมูลทั้งหมด เรียงจากล่าสุดไปเก่าสุด
$sql = "SELECT * FROM bmi_records ORDER BY id DESC";
$result = $conn->query($sql);

$history = array();

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $history[] = $row;
    }
}

echo json_encode($history);
$conn->close();
?>