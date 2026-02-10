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
