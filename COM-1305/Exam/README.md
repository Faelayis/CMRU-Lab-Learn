`12-26-66.py`<br>
สร้าง: 20 ธ.ค. 2566 เวลา 02:21<br>
อัปเดต: 26 ธ.ค. 2566 เวลา 09:09<br>
```py
month = {
    1: "มกราคม",
    2: "กุมภาพันธ์",
    3: "มีนาคม",
    4: "เมษายน",
    5: "พฤษภาคม",
    6: "มิถุนายน",
    7: "กรกฎาคม",
    8: "สิงหาคม",
    9: "กันยายน",
    10: "ตุลาคม",
    11: "พฤศจิกายน",
    12: "ธันวาคม",
}

month_number = int(input("Enter Month Number : "))

if month_number in month:
    print(f"เดือนที่ {month_number} คือ {month[month_number]}")
else:
    print("เลขเดือนไม่ถูกต้อง")

```
`test.py`<br>
สร้าง: 26 ธ.ค. 2566 เวลา 09:25<br>
อัปเดต: 16 ม.ค. 2567 เวลา 08:48<br>
```py
text = input("ป้อนสัญลักษณ์พิเศษ : ")
num = int(input("ป้อนตัวเลข : "))

loop = 1
count = 0

for i in range(1, num + 1):
    count += 1
    for j in range(1, num + 1):
        if loop % 2 == 0:
            print(count, end=" ")
        else:
            print(text, end=" ")
        loop += 1

```
