<?php
header("Access-Control-Allow-Origin: *"); // อนุญาตทุกเว็บให้เข้าถึงได้
header("Access-Control-Allow-Headers: Content-Type"); // อนุญาตให้ส่ง Header แบบ JSON
header("Access-Control-Allow-Methods: POST, GET, OPTIONS"); // อนุญาต method ต่างๆ
// ----------------------------------------------

header("Content-Type: application/json");
$conn = new mysqli("localhost", "root", "", "health_app");

// รับค่า JSON จาก Flutter
$data = json_decode(file_get_contents("php://input"), true);

if(isset($data['weight']) && isset($data['height']) && isset($data['bmi'])) {
    $weight = $data['weight'];
    $height = $data['height'];
    $bmi = $data['bmi'];

    $sql = "INSERT INTO bmi_records (weight, height, bmi) VALUES ('$weight', '$height', '$bmi')";
    
    if ($conn->query($sql) === TRUE) {
        echo json_encode(["status" => "success", "message" => "Record saved"]);
    } else {
        echo json_encode(["status" => "error", "message" => "Error: " . $conn->error]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "Invalid input"]);
}
$conn->close();
?>