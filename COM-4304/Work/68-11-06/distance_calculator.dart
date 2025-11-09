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
