<?php
// แสดงชื่อและนามสกุลนักศึกษาเป็นภาษาอังกฤษ
$firstName = "fae";
$lastName = "layis";

echo "Name: " . $firstName . " " . $lastName . "<br>";

// ใช้ฟังก์ชัน strtoupper() เพื่อแปลงเป็นตัวพิมพ์ใหญ่ทั้งหมด
echo "Uppercase: " . strtoupper($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน strtolower() เพื่อแปลงเป็นตัวพิมพ์เล็กทั้งหมด
echo "Lowercase: " . strtolower($firstName . " " . $lastName) . "<br>";

// ใช้ฟังก์ชัน ucfirst() เพื่อแปลงตัวแรกให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter: " . ucfirst($firstName) . " " . ucfirst($lastName) . "<br>";

// ใช้ฟังก์ชัน ucwords() เพื่อแปลงตัวแรกของคำในประโยคให้เป็นตัวพิมพ์ใหญ่
echo "Uppercase first letter of each word: " . ucwords($firstName . " " . $lastName) . "<br>";

// นับจำนวนตัวอักษร
echo "Number of characters: " . strlen($firstName . $lastName) . "<br>";

// แยกข้อความชื่อกับนามสกุลออกจากกัน
echo "First name: " . $firstName . "<br>";
echo "Last name: " . $lastName . "<br>";

// แสดงวันที่ปัจจุบัน
echo "Current date: " . date("Y-m-d") . "<br>";
