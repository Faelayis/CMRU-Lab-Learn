
## Work/68-11-06

##### `average_calculator.dart`<br>
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

##### `cylinder_volume.dart`<br>
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

##### `distance_calculator.dart`<br>
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


## Work/68-11-13

##### `1.dart`<br>
Create: 13 พ.ย. 2568 time 15:28<br>
```dart
import 'dart:io';

void main() {
  String? input = stdin.readLineSync();

  int? n = int.tryParse(input!);

  if (n != null && n > 0) {
    print(n);

    for (int i = 1; i <= n; i++) {
      print(i);
    }
  }
}

```

##### `2.dart`<br>
Create: 13 พ.ย. 2568 time 15:28<br>
```dart
import 'dart:io';

void main() {
  String? input = stdin.readLineSync();

  int? n = int.tryParse(input!);

  if (n != null && n > 0) {
    print(n);

    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        print(i);
      }
    }
  }
}

```

##### `3.dart`<br>
Create: 13 พ.ย. 2568 time 15:28<br>
```dart
import 'dart:io';

void main() {
  String? input = stdin.readLineSync();

  int? n = int.tryParse(input!);

  if (n != null && n > 0) {
    int count = 0;
    List<int> divisible = [];

    for (int i = 1; i <= n; i++) {
      if (i % 7 == 0) {
        count++;
        divisible.add(i);
      }
    }

    print(n);
    print(divisible.join(', '));
    print(count);
  }
}

```

##### `4.dart`<br>
Create: 13 พ.ย. 2568 time 15:28<br>
```dart
import 'dart:io';

void main() {
  List<int> numbers = [];

  for (int i = 1; i <= 10; i++) {
    while (true) {
      String? input = stdin.readLineSync();

      if (input != null && input.isNotEmpty) {
        int? number = int.tryParse(input);
        if (number != null) {
          numbers.add(number);
          break;
        }
      }
    }
  }

  int max = numbers[0];
  int min = numbers[0];

  for (int number in numbers) {
    if (number > max) {
      max = number;
    }
    if (number < min) {
      min = number;
    }
  }

  print(max);
  print(min);
}

```

##### `5.dart`<br>
Create: 13 พ.ย. 2568 time 15:28<br>
```dart
import 'dart:io';

void main() {
  List<int> numbers = [];

  for (int i = 1; i <= 10; i++) {
    while (true) {
      String? input = stdin.readLineSync();

      if (input != null && input.isNotEmpty) {
        int? number = int.tryParse(input);
        if (number != null) {
          numbers.add(number);
          break;
        }
      }
    }
  }

  numbers.sort((a, b) => b.compareTo(a));

  for (int i = 0; i < numbers.length; i++) {
    print('${i + 1}. ${numbers[i]}');
  }

  print(numbers.join(', '));
}

```


## project/simple/lib

##### `main.dart`<br>
Create: 20 พ.ย. 2568 time 15:41<br>
Update: 27 พ.ย. 2568 time 15:56<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyWidget());
}

class MyWidget extends StatefulWidget {
  const MyWidget({super.key});

  @override
  State<MyWidget> createState() => MyWidgetState();
}

class MyWidgetState extends State<MyWidget> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "My Evernight",
      home: Scaffold(
        appBar: AppBar(
          title: Row(children: [SizedBox(width: 8), Text("My Evernight")]),
          titleTextStyle: TextStyle(
            color: Colors.white,
            fontSize: 20,
            fontWeight: FontWeight.bold,
          ),
          backgroundColor: Colors.orange,
        ),
        backgroundColor: Colors.white,
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Text(
                "Hello Evernight",
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              Text(
                '$counter',
                style: Theme.of(context).textTheme.headlineMedium,
              ),
              Image.network(
                'https://raw.githubusercontent.com/Faelayis/CMRU-Lab-Learn/main/resources/evernight.gif',
                width: (200 + counter * 10).toDouble(),
                height: (200 + counter * 10).toDouble(),
              ),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  FloatingActionButton(
                    onPressed: () {
                      setState(() {
                        counter--;
                      });
                    },
                    child: Icon(Icons.remove),
                  ),
                  SizedBox(width: 20),
                  FloatingActionButton(
                    onPressed: () {
                      setState(() {
                        counter++;
                      });
                    },
                    child: Icon(Icons.add),
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}

```
