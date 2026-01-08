`1.dart`<br>
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
