`1.dart`<br>
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
`2.dart`<br>
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
`3.dart`<br>
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
`4.dart`<br>
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
`5.dart`<br>
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
