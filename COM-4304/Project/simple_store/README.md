# Simple Store

มินิโปรเจกต์ Flutter ตัวอย่างการนำทางระหว่างหน้า Home และ Detail พร้อมส่งข้อมูลสินค้าระหว่างหน้า

## Slide Guide

1. หน้า Home แสดงสินค้าอย่างน้อย 2 รายการ พร้อมปุ่ม "ดูรายละเอียด"
2. แตะสินค้าหรือปุ่ม → `Navigator.push()` เปิด Detail พร้อมส่ง `Product`
3. หน้า Detail แสดงชื่อ ราคา รูปภาพ และมีปุ่ม "ย้อนกลับ" (`Navigator.pop()`)
4. ทดสอบ Hot Reload หลังแก้ไข UI เพื่อเห็นผลทันที
5. ปิดแอปด้วยปุ่ม back ของระบบหรือปุ่มย้อนกลับในแอป

## วิธีรันโปรเจกต์

- โหลดโปรเจกต์ `git clone https://github.com/faelayis/CMRU-Lab-Learn.git`
- เข้าไปยังโฟลเดอร์: `cd CMRU-Lab-Learn/COM-4304/Project/simple_store`
- ติดตั้ง dependency: `flutter pub get`
- รันแอป: `flutter run` (เลือก device หรือ emulator ที่ต้องการ)

## โครงสร้างหน้าสำคัญ

- `main.dart`
  - `MyApp` สร้าง `MaterialApp` ตั้งธีมสี และกำหนด `home` เป็น `HomePage`
  - `HomePage` แสดง `ListView` ของ `Product` สองชิ้น (ชื่อ ราคา รูป) ใช้ `Navigator.push()` ส่ง `Product` ไป `DetailPage`
  - `DetailPage` รับ `Product` ผ่าน constructor แสดงข้อมูล และกดปุ่ม `ย้อนกลับ` เพื่อ `Navigator.pop()`

## คำสั่ง Flutter ที่ใช้บ่อยในโปรเจกต์นี้

- สร้างเส้นทาง: `MaterialPageRoute(builder: (_) => DetailPage(product: product))`
- ไปหน้าถัดไปพร้อมข้อมูล: `Navigator.push(context, route)`
- กลับหน้าก่อน: `Navigator.pop(context)`

## ขั้นตอนทดสอบอย่างรวดเร็ว

- เปิดหน้า Home → เห็นรายการ Blue T-Shirt และ Canvas Tote
- แตะรายการ → ไปหน้า Detail แสดงชื่อ ราคา รูปภาพ
- แตะ "ย้อนกลับ" → กลับหน้า Home ได้ปกติ
