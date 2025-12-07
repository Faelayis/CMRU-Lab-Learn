
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


## simple2/lib

##### `main.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
```dart
import 'package:flutter/material.dart';
import 'package:simple2/widget/dropdown.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: .fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // TRY THIS: Try changing the color here to a specific color (to
        // Colors.amber, perhaps?) and trigger a hot reload to see the AppBar
        // change color while the other colors stay the same.
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [const DropdownWidget()],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}

```


## simple2/lib/widget

##### `dropdown.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
```dart
import 'package:flutter/material.dart';

class DropdownWidget extends StatefulWidget {
  const DropdownWidget({super.key});

  @override
  State<DropdownWidget> createState() => _DropdownWidgetState();
}

class _DropdownWidgetState extends State<DropdownWidget> {
  String? _selectedItem = 'Option A';

  final List<String> _dropdownItems = [
    'Option A',
    'Option B',
    'Option C',
    'Option D',
  ];

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          const Text(
            'เลือกตัวเลือก:',
            style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
          ),
          const SizedBox(height: 16),

          DropdownButton<String>(
            value: _selectedItem,
            isExpanded: true,
            icon: const Icon(Icons.arrow_drop_down),
            elevation: 16,
            style: const TextStyle(color: Colors.blue, fontSize: 16),
            underline: Container(height: 2, color: Colors.blueAccent),
            onChanged: (String? newValue) {
              setState(() {
                _selectedItem = newValue;
              });
              if (newValue != null) {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(
                    content: Text('คุณเลือก: $newValue'),
                    duration: const Duration(seconds: 2),
                  ),
                );
              }
            },
            items: _dropdownItems.map<DropdownMenuItem<String>>((String value) {
              return DropdownMenuItem<String>(value: value, child: Text(value));
            }).toList(),
          ),

          const SizedBox(height: 24),

          Container(
            padding: const EdgeInsets.all(16),
            decoration: BoxDecoration(
              color: Colors.blue.shade50,
              borderRadius: BorderRadius.circular(8),
              border: Border.all(color: Colors.blue.shade200),
            ),
            child: Row(
              children: [
                const Icon(Icons.info_outline, color: Colors.blue),
                const SizedBox(width: 12),
                Expanded(
                  child: Text(
                    'ตัวเลือกปัจจุบัน: ${_selectedItem ?? "ไม่ได้เลือก"}',
                    style: const TextStyle(
                      fontSize: 16,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}

```


## simple2/test

##### `widget_test.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
```dart
// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:simple2/main.dart';

void main() {
  testWidgets('Counter increments smoke test', (WidgetTester tester) async {
    // Build our app and trigger a frame.
    await tester.pumpWidget(const MyApp());

    // Verify that our counter starts at 0.
    expect(find.text('0'), findsOneWidget);
    expect(find.text('1'), findsNothing);

    // Tap the '+' icon and trigger a frame.
    await tester.tap(find.byIcon(Icons.add));
    await tester.pump();

    // Verify that our counter has incremented.
    expect(find.text('0'), findsNothing);
    expect(find.text('1'), findsOneWidget);
  });
}

```
