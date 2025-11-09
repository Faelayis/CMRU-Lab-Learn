`average_calculator.dart`<br>
Create: 9 พ.ย. 2568 time 18:57<br>
```dart
import 'dart:io';

void main() {
  print('คำนวณค่าเฉลี่ยของตัวเลข 3 จำนวน');
  print('กรุณาป้อนตัวเลขจำนวนที่ 1 (A):');
  String? aInput = stdin.readLineSync();
  double a = double.tryParse(aInput ?? '') ?? 0;

  print('กรุณาป้อนตัวเลขจำนวนที่ 2 (B):');
  String? bInput = stdin.readLineSync();
  double b = double.tryParse(bInput ?? '') ?? 0;

  print('กรุณาป้อนตัวเลขจำนวนที่ 3 (C):');
  String? cInput = stdin.readLineSync();
  double c = double.tryParse(cInput ?? '') ?? 0;

  double average = (a + b + c) / 3;
  double sum = a + b + c;

  print('\nผลลัพธ์:');
  print('ตัวเลขที่ 1 (A): $a');
  print('ตัวเลขที่ 2 (B): $b');
  print('ตัวเลขที่ 3 (C): $c');
  print('ผลรวม: $sum');
  print('ค่าเฉลี่ย: ${average.toStringAsFixed(2)}');
}

```
`cylinder_volume.dart`<br>
Create: 9 พ.ย. 2568 time 18:57<br>
```dart
import 'dart:io';
import 'dart:math';

void main() {
  print('คำนวณปริมาตรทรงกระบอก');
  print('กรุณาป้อนรัศมี (หน่วย: เซนติเมตร):');
  String? radiusInput = stdin.readLineSync();
  double radius = double.tryParse(radiusInput ?? '') ?? 0;

  print('กรุณาป้อนความสูง (หน่วย: เซนติเมตร):');
  String? heightInput = stdin.readLineSync();
  double height = double.tryParse(heightInput ?? '') ?? 0;

  if (radius <= 0 || height <= 0) {
    print('ข้อผิดพลาด: รัศมีและความสูงต้องมีค่ามากกว่า 0');
    return;
  }

  double volume = pi * radius * radius * height;

  print('\nผลลัพธ์:');
  print('รัศมี: $radius เซนติเมตร');
  print('ความสูง: $height เซนติเมตร');
  print('ปริมาตรทรงกระบอก: ${volume.toStringAsFixed(2)} ลูกบาศก์เซนติเมตร');
}

```
`distance_calculator.dart`<br>
Create: 9 พ.ย. 2568 time 18:57<br>
```dart
import 'dart:io';

void main() {
  print('คำนวณระยะทางรวมที่เดินทางได้');
  print('กรุณาป้อนความเร็ว (กิโลเมตรต่อชั่วโมง):');
  String? speedInput = stdin.readLineSync();
  double speed = double.tryParse(speedInput ?? '') ?? 0;

  print('กรุณาป้อนเวลาที่ใช้ในการเดินทาง (ชั่วโมง):');
  String? timeInput = stdin.readLineSync();
  double time = double.tryParse(timeInput ?? '') ?? 0;

  if (speed <= 0 || time <= 0) {
    print('ข้อผิดพลาด: ความเร็วและเวลาต้องมีค่ามากกว่า 0');
    return;
  }

  double distance = speed * time;

  print('\nผลลัพธ์:');
  print('ความเร็ว: $speed กิโลเมตรต่อชั่วโมง');
  print('เวลา: $time ชั่วโมง');
  print('ระยะทางรวมที่เดินทางได้: ${distance.toStringAsFixed(2)} กิโลเมตร');
}

```
