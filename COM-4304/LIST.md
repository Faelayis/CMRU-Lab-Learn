
## PracticalTest

##### `1.dart`<br>
Create: 8 ม.ค. 2569 time 14:22<br>
```dart
import 'dart:io';

void main() {
  List<Map<String, dynamic>> products = [];

  for (int i = 1; i <= 3; i++) {
    print('สินค้ารายการที่ $i:');
    String? productId = stdin.readLineSync();

    print('ราคาสินค้ารายการที่ $i:');
    double price = double.parse(stdin.readLineSync() ?? '0');

    products.add({'id': productId, 'price': price});
    print('\n');
  }

  products.sort((a, b) => a['price'].compareTo(b['price']));

  double allPrice = products.fold(0, (sum, item) => sum + item['price']);

  Map<String, dynamic> freeProduct = products[0];

  double freeProductPrice = freeProduct['price'];
  double endPrice = allPrice - freeProduct['price'];

  print('ราคาสินค้ารวม: $allPrice บาท\n');
  print('รหัสสินค้าที่ได้ส่วนลด: ${freeProduct['id']}');
  print('ราคาสินค้าส่วนลด: $freeProductPrice บาท\n');
  print('ราคาหลังได้รับส่วนลด: $endPrice บาท');
}

```


## PracticalTest/currency_exchange/lib

##### `main.dart`<br>
Create: 10 ก.พ. 2569 time 08:48<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Currency Exchange',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const CurrencyExchangePage(),
    );
  }
}

enum Currency { usd, cny, jpy, krw }

class CurrencyExchangePage extends StatefulWidget {
  const CurrencyExchangePage({super.key});

  @override
  State<CurrencyExchangePage> createState() => _CurrencyExchangePageState();
}

class _CurrencyExchangePageState extends State<CurrencyExchangePage> {
  final TextEditingController textInputController = TextEditingController();

  Currency selectedCurrency = Currency.usd;
  double result = 0;

  final Map<Currency, double> rates = {
    Currency.cny: 0.22,
    Currency.usd: 0.031,
    Currency.jpy: 5,
    Currency.krw: 46,
  };

  final Map<Currency, String> currencyNames = {
    Currency.usd: 'ดอลลาร์',
    Currency.cny: 'หยวน',
    Currency.jpy: 'เยน',
    Currency.krw: 'วอน',
  };

  final Map<Currency, String> currencySymbols = {
    Currency.usd: '\$',
    Currency.cny: '¥',
    Currency.jpy: '¥',
    Currency.krw: '₩',
  };

  void cal() {
    final baht = double.tryParse(textInputController.text) ?? 0;

    setState(() {
      result = baht * rates[selectedCurrency]!;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              controller: textInputController,
              keyboardType: TextInputType.number,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                prefixIcon: Icon(Icons.money),
                suffixText: 'บาท',
              ),
              onChanged: (_) => cal(),
            ),
            const SizedBox(height: 20),
            const Text(
              'เลือกสกุลเงินที่ต้องการแปลง:',
              style: TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 10),
            SegmentedButton<Currency>(
              segments: const [
                ButtonSegment(
                  value: Currency.usd,
                  label: Text('USD'),
                  icon: Icon(Icons.attach_money),
                ),
                ButtonSegment(
                  value: Currency.cny,
                  label: Text('CNY'),
                  icon: Icon(Icons.currency_yuan),
                ),
                ButtonSegment(
                  value: Currency.jpy,
                  label: Text('JPY'),
                  icon: Icon(Icons.currency_yen),
                ),
                ButtonSegment(
                  value: Currency.krw,
                  label: Text('KRW'),
                  icon: Icon(Icons.monetization_on),
                ),
              ],
              selected: {selectedCurrency},
              onSelectionChanged: (Set<Currency> newSelection) {
                setState(() {
                  selectedCurrency = newSelection.first;

                  cal();
                });
              },
            ),
            const SizedBox(height: 30),
            Card(
              elevation: 4,
              child: Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  children: [
                    Text(
                      '${currencySymbols[selectedCurrency]} ${result.toStringAsFixed(2)}',
                      style: const TextStyle(
                        fontSize: 36,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    Text(
                      currencyNames[selectedCurrency]!,
                      style: const TextStyle(fontSize: 16, color: Colors.grey),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

```


## Project/fruit_list/lib

##### `main.dart`<br>
Create: 25 ม.ค. 2569 time 20:39<br>
Last edited: Time 21:45<br>

```dart
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (context) => FavoriteProvider(),
      child: const MyApp(),
    ),
  );
}

class Fruit {
  final String id;
  final String name;
  final String emoji;

  Fruit({required this.id, required this.name, required this.emoji});
}

class FavoriteProvider extends ChangeNotifier {
  final List<Fruit> _fruits = [
    Fruit(id: '1', name: 'แอปเปิ้ล', emoji: '🍎'),
    Fruit(id: '2', name: 'กล้วย', emoji: '🍌'),
    Fruit(id: '3', name: 'ส้ม', emoji: '🍊'),
    Fruit(id: '4', name: 'องุ่น', emoji: '🍇'),
    Fruit(id: '5', name: 'แตงโม', emoji: '🍉'),
    Fruit(id: '6', name: 'สตรอว์เบอร์รี', emoji: '🍓'),
    Fruit(id: '7', name: 'เชอร์รี่', emoji: '🍒'),
    Fruit(id: '8', name: 'พีช', emoji: '🍑'),
    Fruit(id: '9', name: 'มะนาว', emoji: '🍋'),
    Fruit(id: '10', name: 'สับปะรด', emoji: '🍍'),
  ];

  final Set<String> _favoriteIds = {};

  List<Fruit> get fruits => _fruits;
  List<Fruit> get favorites =>
      _fruits.where((fruit) => _favoriteIds.contains(fruit.id)).toList();

  bool isFavorite(String id) => _favoriteIds.contains(id);

  void toggleFavorite(String id) {
    if (_favoriteIds.contains(id)) {
      _favoriteIds.remove(id);
    } else {
      _favoriteIds.add(id);
    }
    notifyListeners();
  }

  void removeFromFavorites(String id) {
    _favoriteIds.remove(id);
    notifyListeners();
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Fruit Favorites',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.green),
        useMaterial3: true,
      ),
      home: const ProductListScreen(),
    );
  }
}

class ProductListScreen extends StatelessWidget {
  const ProductListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('🍎 รายการผลไม้'),
        actions: [
          IconButton(
            icon: const Icon(Icons.favorite, color: Color(0xFFFE926B)),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => const FavoritesScreen(),
                ),
              );
            },
            tooltip: 'รายการโปรด',
          ),
        ],
      ),
      body: Consumer<FavoriteProvider>(
        builder: (context, favoriteProvider, child) {
          return ListView.builder(
            padding: const EdgeInsets.all(8),
            itemCount: favoriteProvider.fruits.length,
            itemBuilder: (context, index) {
              final fruit = favoriteProvider.fruits[index];
              final isFavorite = favoriteProvider.isFavorite(fruit.id);

              return Card(
                margin: const EdgeInsets.symmetric(vertical: 4),
                child: ListTile(
                  leading: Text(
                    fruit.emoji,
                    style: const TextStyle(fontSize: 32),
                  ),
                  title: Text(
                    fruit.name,
                    style: const TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                  trailing: IconButton(
                    icon: Icon(
                      isFavorite ? Icons.favorite : Icons.favorite_border,
                      color: isFavorite ? const Color(0xFFFE926B) : Colors.grey,
                      size: 28,
                    ),
                    onPressed: () {
                      favoriteProvider.toggleFavorite(fruit.id);

                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text(
                            isFavorite
                                ? 'ลบ ${fruit.name} ออกจากรายการโปรด'
                                : 'เพิ่ม ${fruit.name} เข้ารายการโปรด',
                          ),
                          duration: const Duration(seconds: 1),
                          behavior: SnackBarBehavior.floating,
                        ),
                      );
                    },
                  ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}

class FavoritesScreen extends StatelessWidget {
  const FavoritesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('🧡 รายการโปรด')),
      body: Consumer<FavoriteProvider>(
        builder: (context, favoriteProvider, child) {
          final favorites = favoriteProvider.favorites;

          if (favorites.isEmpty) {
            return const Center(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(Icons.favorite_border, size: 80, color: Colors.grey),
                  SizedBox(height: 16),
                  Text(
                    'ยังไม่มีรายการโปรด',
                    style: TextStyle(fontSize: 18, color: Colors.grey),
                  ),
                  SizedBox(height: 8),
                  Text(
                    'กดปุ่มหัวใจที่หน้าหลักเพื่อเพิ่มรายการโปรด',
                    style: TextStyle(fontSize: 14, color: Colors.grey),
                  ),
                ],
              ),
            );
          }

          return ListView.builder(
            padding: const EdgeInsets.all(8),
            itemCount: favorites.length,
            itemBuilder: (context, index) {
              final fruit = favorites[index];

              return Card(
                margin: const EdgeInsets.symmetric(vertical: 4),
                child: ListTile(
                  leading: Text(
                    fruit.emoji,
                    style: const TextStyle(fontSize: 32),
                  ),
                  title: Text(
                    fruit.name,
                    style: const TextStyle(
                      fontSize: 18,
                      fontWeight: FontWeight.w500,
                    ),
                  ),
                  trailing: IconButton(
                    icon: const Icon(Icons.delete, color: Colors.red, size: 28),
                    onPressed: () {
                      favoriteProvider.removeFromFavorites(fruit.id);

                      ScaffoldMessenger.of(context).showSnackBar(
                        SnackBar(
                          content: Text('ลบ ${fruit.name} ออกจากรายการโปรด'),
                          duration: const Duration(seconds: 1),
                          behavior: SnackBarBehavior.floating,
                        ),
                      );
                    },
                  ),
                ),
              );
            },
          );
        },
      ),
    );
  }
}

```


## Project/menu/lib

##### `main.dart`<br>
Create: 21 ธ.ค. 2568 time 13:24<br>
Update: 8 ม.ค. 2569 time 13:22<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MenuItem {
  final String nameTH;
  final String nameEN;
  final double price;
  final String imageUrl;

  const MenuItem({
    required this.nameTH,
    required this.nameEN,
    required this.price,
    required this.imageUrl,
  });
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'เมนูอาหาร', home: const MenuPage());
  }
}

class MenuPage extends StatelessWidget {
  const MenuPage({super.key});

  @override
  Widget build(BuildContext context) {
    final List<MenuItem> menuItems = [
      const MenuItem(
        nameTH: 'ผัดไทย',
        nameEN: 'Pad Thai',
        price: 60,
        imageUrl:
            'https://images.unsplash.com/photo-1559314809-0d155014e29e?w=400',
      ),
      const MenuItem(
        nameTH: 'ต้มยำกุ้ง',
        nameEN: 'Tom Yum Goong',
        price: 120,
        imageUrl:
            'https://images.unsplash.com/photo-1548943487-a2e4e43b4853?w=400',
      ),
      const MenuItem(
        nameTH: 'ข้าวผัด',
        nameEN: 'Fried Rice',
        price: 50,
        imageUrl:
            'https://images.unsplash.com/photo-1603133872878-684f208fb84b?w=400',
      ),
      const MenuItem(
        nameTH: 'แกงเขียวหวาน',
        nameEN: 'Green Curry',
        price: 80,
        imageUrl:
            'https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?w=400',
      ),
      const MenuItem(
        nameTH: 'ส้มตำ',
        nameEN: 'Som Tam (Papaya Salad)',
        price: 45,
        imageUrl:
            'https://images.unsplash.com/photo-1617093727343-374698b1b08d?w=400',
      ),
    ];

    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'เมนูอาหาร',
          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
        ),
        centerTitle: true,
      ),
      body: ListView.builder(
        padding: const EdgeInsets.all(16),
        itemCount: menuItems.length,
        itemBuilder: (context, index) {
          final item = menuItems[index];
          return Card(
            margin: const EdgeInsets.only(bottom: 16),
            elevation: 4,
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(16),
            ),
            child: ClipRRect(
              borderRadius: BorderRadius.circular(16),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Image.network(
                    item.imageUrl,
                    height: 200,
                    width: double.infinity,
                    fit: BoxFit.cover,
                    loadingBuilder: (context, child, loadingProgress) {
                      if (loadingProgress == null) return child;

                      return SizedBox(
                        height: 200,
                        child: const Center(child: CircularProgressIndicator()),
                      );
                    },
                    errorBuilder: (context, error, stackTrace) {
                      return SizedBox(
                        height: 200,
                        child: const Center(
                          child: Icon(Icons.restaurant, size: 64),
                        ),
                      );
                    },
                  ),
                  Padding(
                    padding: const EdgeInsets.all(16),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          item.nameTH,
                          style: const TextStyle(
                            fontSize: 22,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        const SizedBox(height: 4),
                        Text(
                          item.nameEN,
                          style: TextStyle(
                            fontSize: 16,
                            fontStyle: FontStyle.italic,
                          ),
                        ),
                        const SizedBox(height: 8),
                        Container(
                          padding: const EdgeInsets.symmetric(
                            horizontal: 12,
                            vertical: 6,
                          ),
                          decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(20),
                          ),
                          child: Text(
                            '฿${item.price.toStringAsFixed(0)}',
                            style: const TextStyle(
                              fontSize: 18,
                              fontWeight: FontWeight.bold,
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}

```


## Project/menu/test

##### `widget_test.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
Update: 8 ม.ค. 2569 time 13:22<br>
```dart
// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:menu/main.dart';

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


## Project/mysql/lib

##### `main.dart`<br>
Create: 29 ม.ค. 2569 time 14:26<br>
```dart
import 'dart:convert';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

void main() {
  runApp(
    const MaterialApp(
      home: BmiCalculatorScreen(),
      debugShowCheckedModeBanner: false,
    ),
  );
}

class BmiCalculatorScreen extends StatefulWidget {
  const BmiCalculatorScreen({super.key});

  @override
  State<BmiCalculatorScreen> createState() => _BmiCalculatorScreenState();
}

class _BmiCalculatorScreenState extends State<BmiCalculatorScreen> {
  final TextEditingController _weightController = TextEditingController();
  final TextEditingController _heightController = TextEditingController();

  double? _bmiResult;
  String _message = "";
  bool _isLoading = false;

  // ตัวแปรเก็บรายการประวัติ
  List<dynamic> _historyList = [];

  // กำหนด Base URL (ถ้าเป็น Web ใช้ localhost, ถ้าเป็น Android ใช้ ip address)
  // หมายเหตุ: สำหรับ Web Browser จริง ๆ (Chrome) ใช้ localhost ได้เลย
  final String baseUrl =
      'http://localhost/phpMyAdmin/CMRU-Lab-Learn/COM-4304/API';
  @override
  void initState() {
    super.initState();
    // ดึงข้อมูลเก่าทันทีเมื่อเปิดแอป
    _fetchHistory();
  }

  // ฟังก์ชันดึงข้อมูลประวัติ
  Future<void> _fetchHistory() async {
    try {
      final response = await http.get(Uri.parse('$baseUrl/get_history.php'));

      if (response.statusCode == 200) {
        setState(() {
          _historyList = jsonDecode(response.body);
        });
      }
    } catch (e) {
      print('Error fetching history: $e');
    }
  }

  // ฟังก์ชันคำนวณ BMI
  void _calculateBmi() {
    final double weight = double.tryParse(_weightController.text) ?? 0;
    final double heightCm = double.tryParse(_heightController.text) ?? 0;

    if (weight > 0 && heightCm > 0) {
      final double heightM = heightCm / 100;
      setState(() {
        _bmiResult = weight / (heightM * heightM);
        if (_bmiResult! < 18.5)
          _message = "ผอม";
        else if (_bmiResult! < 23)
          _message = "ปกติ";
        else if (_bmiResult! < 25)
          _message = "ท้วม";
        else
          _message = "อ้วน";
      });
    }
  }

  // ฟังก์ชันบันทึกข้อมูล
  Future<void> _saveToDatabase() async {
    if (_bmiResult == null) return;

    setState(() {
      _isLoading = true;
    });

    try {
      final response = await http.post(
        Uri.parse('$baseUrl/save_bmi.php'),
        headers: {"Content-Type": "application/json"},
        body: jsonEncode({
          "weight": double.parse(_weightController.text),
          "height": double.parse(_heightController.text),
          "bmi": _bmiResult,
        }),
      );

      if (response.statusCode == 200) {
        final data = jsonDecode(response.body);
        if (data['status'] == 'success') {
          ScaffoldMessenger.of(
            context,
          ).showSnackBar(const SnackBar(content: Text('บันทึกสำเร็จ!')));
          // *** สำคัญ: บันทึกเสร็จแล้ว ให้ดึงข้อมูลใหม่ทันที ***
          _fetchHistory();
        }
      }
    } catch (e) {
      ScaffoldMessenger.of(
        context,
      ).showSnackBar(SnackBar(content: Text('Error: $e')));
    } finally {
      setState(() {
        _isLoading = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('BMI Web + MySQL'),
        backgroundColor: Colors.teal,
      ),
      body: Row(
        // ใช้ Row จัด layout (ซ้าย: คำนวณ, ขวา: ตาราง) ถ้าหน้าจอกว้าง หรือใช้ Column ถ้าหน้าจอแคบ
        children: [
          // ส่วนที่ 1: Expanded ใช้แบ่งพื้นที่หน้าจอ
          Expanded(
            flex: 1, // ให้ความกว้างส่วนนี้เป็น 1 ส่วน
            child: SingleChildScrollView(
              padding: const EdgeInsets.all(20),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: [
                  const Text(
                    "คำนวณ BMI",
                    style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
                  ),
                  const SizedBox(height: 10),
                  TextField(
                    controller: _weightController,
                    decoration: const InputDecoration(
                      labelText: 'น้ำหนัก (kg)',
                      border: OutlineInputBorder(),
                    ),
                  ),
                  const SizedBox(height: 10),
                  TextField(
                    controller: _heightController,
                    decoration: const InputDecoration(
                      labelText: 'ส่วนสูง (cm)',
                      border: OutlineInputBorder(),
                    ),
                  ),
                  const SizedBox(height: 10),
                  ElevatedButton(
                    onPressed: _calculateBmi,
                    style: ElevatedButton.styleFrom(
                      backgroundColor: Colors.teal,
                      foregroundColor: Colors.white,
                    ),
                    child: const Text('คำนวณ'),
                  ),
                  const SizedBox(height: 20),

                  if (_bmiResult != null) ...[
                    Card(
                      color: Colors.teal.shade50,
                      child: Padding(
                        padding: const EdgeInsets.all(15.0),
                        child: Column(
                          children: [
                            Text(
                              "BMI: ${_bmiResult!.toStringAsFixed(2)}",
                              style: const TextStyle(
                                fontSize: 30,
                                fontWeight: FontWeight.bold,
                                color: Colors.teal,
                              ),
                            ),
                            Text(
                              _message,
                              style: const TextStyle(fontSize: 18),
                            ),
                            const SizedBox(height: 10),
                            _isLoading
                                ? const CircularProgressIndicator()
                                : ElevatedButton.icon(
                                    onPressed: _saveToDatabase,
                                    icon: const Icon(Icons.save),
                                    label: const Text("บันทึกลง Database"),
                                  ),
                          ],
                        ),
                      ),
                    ),
                  ],
                ],
              ),
            ),
          ),

          // ส่วนที่ 2: เส้นคั่นแนวตั้ง
          const VerticalDivider(width: 1),

          // ส่วนที่ 3: พื้นที่แสดงรายการประวัติ (History)
          Expanded(
            flex: 1, // ให้พื้นที่เท่ากันกับฝั่งซ้าย
            child: Column(
              children: [
                Container(
                  padding: const EdgeInsets.all(15),
                  color: Colors.grey.shade200,
                  width: double.infinity,
                  child: const Text(
                    "ประวัติการคำนวณ (จาก MySQL)",
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                ),
                Expanded(
                  // ใช้ ListView.builder สร้างรายการ
                  child: _historyList.isEmpty
                      ? const Center(child: Text("ยังไม่มีข้อมูล"))
                      : ListView.builder(
                          itemCount: _historyList.length,
                          itemBuilder: (context, index) {
                            final item = _historyList[index];
                            return Card(
                              margin: const EdgeInsets.symmetric(
                                horizontal: 10,
                                vertical: 5,
                              ),
                              child: ListTile(
                                leading: CircleAvatar(
                                  backgroundColor: Colors.teal,
                                  child: Text(
                                    double.parse(
                                      item['bmi'],
                                    ).toStringAsFixed(1),
                                    style: const TextStyle(
                                      color: Colors.white,
                                      fontSize: 12,
                                    ),
                                  ),
                                ),
                                title: Text(
                                  "น้ำหนัก: ${item['weight']} kg | สูง: ${item['height']} cm",
                                ),
                                subtitle: Text(
                                  "วันที่: ${item['recorded_at']}",
                                ),
                              ),
                            );
                          },
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


## Project/simple/lib

##### `main.dart`<br>
Create: 20 พ.ย. 2568 time 15:41<br>
Update: 8 ม.ค. 2569 time 13:22<br>
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


## Project/simple2/lib

##### `main.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
Update: 8 ม.ค. 2569 time 13:22<br>
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


## Project/simple2/lib/widget

##### `dropdown.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
Update: 8 ม.ค. 2569 time 13:22<br>
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


## Project/simple2/test

##### `widget_test.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
Update: 8 ม.ค. 2569 time 13:22<br>
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


## Project/simple_store/lib

##### `main.dart`<br>
Create: 19 ม.ค. 2569 time 16:47<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Simple Store',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.teal),
        useMaterial3: true,
      ),
      home: const HomePage(),
    );
  }
}

class Product {
  const Product({required this.name, required this.price, required this.image});

  final String name;
  final double price;
  final String image;
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  static const products = <Product>[
    Product(
      name: 'Blue T-Shirt',
      price: 399,
      image: 'https://i.imgur.com/MiiJiy4.jpeg',
    ),
    Product(
      name: 'Canvas Tote',
      price: 299,
      image: 'https://i.imgur.com/ydi37eR.jpeg',
    ),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Simple Store')),
      body: ListView.separated(
        padding: const EdgeInsets.all(16),
        itemCount: products.length,
        separatorBuilder: (_, __) => const SizedBox(height: 12),
        itemBuilder: (context, index) {
          final product = products[index];
          return _ProductCard(
            product: product,
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (_) => DetailPage(product: product)),
              );
            },
          );
        },
      ),
    );
  }
}

class _ProductCard extends StatelessWidget {
  const _ProductCard({required this.product, required this.onTap});

  final Product product;
  final VoidCallback onTap;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onTap,
      borderRadius: BorderRadius.circular(16),
      child: Ink(
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(16),
          boxShadow: const [
            BoxShadow(
              color: Colors.black12,
              blurRadius: 8,
              offset: Offset(0, 4),
            ),
          ],
        ),
        child: Row(
          children: [
            ClipRRect(
              borderRadius: const BorderRadius.only(
                topLeft: Radius.circular(16),
                bottomLeft: Radius.circular(16),
              ),
              child: Image.network(
                product.image,
                width: 120,
                height: 120,
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(width: 16),
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    product.name,
                    style: Theme.of(context).textTheme.titleMedium,
                  ),
                  const SizedBox(height: 8),
                  Text('฿${product.price.toStringAsFixed(0)}'),
                  const SizedBox(height: 12),
                  FilledButton(
                    onPressed: onTap,
                    child: const Text('ดูรายละเอียด'),
                  ),
                ],
              ),
            ),
            const SizedBox(width: 12),
          ],
        ),
      ),
    );
  }
}

class DetailPage extends StatelessWidget {
  const DetailPage({super.key, required this.product});

  final Product product;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(product.name),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () => Navigator.pop(context),
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            ClipRRect(
              borderRadius: BorderRadius.circular(24),
              child: Image.network(
                product.image,
                height: 240,
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(height: 24),
            Text(
              product.name,
              style: Theme.of(context).textTheme.headlineSmall,
            ),
            const SizedBox(height: 12),
            Text(
              'ราคา ฿${product.price.toStringAsFixed(0)}',
              style: Theme.of(context).textTheme.titleMedium,
            ),
            const SizedBox(height: 24),
            const Text(
              'รายละเอียดสินค้า: เสื้อยืดและกระเป๋าผ้าแบบเรียบง่าย เหมาะกับการใช้งานประจำวัน',
            ),
            const Spacer(),
            ElevatedButton.icon(
              onPressed: () => Navigator.pop(context),
              icon: const Icon(Icons.arrow_back),
              label: const Text('ย้อนกลับ'),
            ),
          ],
        ),
      ),
    );
  }
}

```


## Project/simple_store/test

##### `widget_test.dart`<br>
Create: 7 ธ.ค. 2568 time 21:48<br>
Update: 19 ม.ค. 2569 time 16:47<br>
```dart
// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility in the flutter_test package. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';

import 'package:simple_store/main.dart';

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
