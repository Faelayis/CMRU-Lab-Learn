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
