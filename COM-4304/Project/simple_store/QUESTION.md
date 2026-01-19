# คำถามเกี่ยวกับ Navigator และการนำทางใน Flutter

1) **Navigator เป็นโครงสร้างข้อมูลแบบใด?**

- เป็น **Stack** เพราะมีพฤติกรรม LIFO: หน้าที่ถูก `push` เข้าไปจะอยู่บนสุดและถูกนำออกด้วย `pop` ก่อนเสมอ

1) **Navigator.push() vs Navigator.pop() ต่างกันอย่างไรในการจัดการหน้าจอ?**

- `Navigator.push()` สร้าง route ใหม่และวางไว้บนสุดของ stack ทำให้แอปแสดงหน้าถัดไป
- `Navigator.pop()` เอา route บนสุดออกจาก stack แล้วกลับไปแสดง route ก่อนหน้า

1) **การส่งข้อมูล (arguments) ไปยังหน้าถัดไปควรใช้วิธีใด?**

- ใช้การส่งผ่าน constructor ของหน้าถัดไป (เป็นวิธีที่อ่านง่ายและ type-safe)

```dart
Navigator.push(
  context,
  MaterialPageRoute(
    builder: (_) => DetailPage(productName: 'Blue T-Shirt'),
  ),
);
```

1) **MaterialPageRoute มีบทบาทอย่างไรในการเปลี่ยนหน้า?**

- เป็นการสร้าง route แบบ material design (มี transition สไตล์ Android) และกำหนด widget ปลายทางใน `builder` ให้ Navigator จัดการ stack ได้อย่างถูกต้อง

1) **จะส่งค่ากลับจาก Child screen มายัง Parent screen ได้อย่างไร?**

- ใช้ `Navigator.pop(context, value)` ส่งค่ากลับ แล้วรอรับค่าด้วย `await Navigator.push(...)`

```dart
final result = await Navigator.push<String>(
  context,
  MaterialPageRoute(builder: (_) => const ChildScreen()),
);
// result จะเป็นค่าที่ child ส่งกลับมาผ่าน Navigator.pop(context, value)
```
