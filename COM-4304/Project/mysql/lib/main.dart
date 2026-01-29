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
