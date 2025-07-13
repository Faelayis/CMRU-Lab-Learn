`5-20-67.py`<br>
Create: 20 ก.พ. 2567 time 10:38<br>
```py
def find_zodiac(year):
    zodiac = [
        "ขวด-หนู",
        "ฉลู-วัว",
        "ขาล-เสือ",
        "เถาะ-กระต่าย",
        "มะโรง-งูใหญ่",
        "มะเส็ง-งูเล็ก",
        "มะเมีย-ม้า",
        "มะแม-แพะ",
        "วอก-ลิง",
        "ระกา-ไก่",
        "จอ-สุนัข",
        "กุน-หมู",
    ]

    index = (year + 5) % 12
    return zodiac[index]


def find_year(year):
    y = year - 543
    if y % 400 == 0:
        return True
    else:
        if y % 4 == 0 and y % 100 != 0:
            return True
    return False


def main():
    while True:
        year = input("ป้อนปี: ")

        if len(year) != 4 or not year.isdigit():
            print("กรุณากรอกปีที่เป็นตัวเลข 4 หลัก ")
        else:
            year = int(year)
            break

    print(f"ปี {year} คือปี {find_zodiac(year)}")

    if find_year(year):
        print("ไม่เป็นปีอธิกสุรทิ")
    else:
        print("เป็นปีอธิกสุรทิ")


main()

```
`12-26-66.py`<br>
Create: 20 ธ.ค. 2566 time 02:21<br>
Update: 26 ธ.ค. 2566 time 09:09<br>
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
Create: 26 ธ.ค. 2566 time 09:25<br>
Update: 16 ม.ค. 2567 time 08:48<br>
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
