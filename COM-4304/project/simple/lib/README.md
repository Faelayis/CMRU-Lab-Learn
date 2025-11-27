`main.dart`<br>
Create: 20 พ.ย. 2568 time 15:41<br>
Update: 27 พ.ย. 2568 time 15:48<br>
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
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
            setState(() {
              counter++;
            });
          },
          tooltip: 'Increment',
          child: Icon(Icons.add),
        ),
      ),
    );
  }
}

```
