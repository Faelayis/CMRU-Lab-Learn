`main.dart`<br>
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
