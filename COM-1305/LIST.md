
## 1-16-67

##### `list.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
y = list([10, 20, 30, 40])

print(y[0])
print(y[1])
print(y[4])  # IndexError: list index out of range

```


## 11-14-66

##### `if.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 11:16<br>
```py
score = 80

if score > 80:
    print("so good")
else:
    print("sorry")

```

##### `index.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 11:16<br>
```py
print("Hello Python")

```


## 11-28-66

##### `if.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
score = 85

if score >= 85:
    print("you so good")
    print("say hi")

```


## 2-13-67

##### `1.1.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import datetime

year = 2024
month = 2
day = 14
today = datetime.date(year, month, day)

today = datetime.date.today()
print(today)

# NOTE: Output
# 2024-02-13

```

##### `1.2.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import datetime

t = datetime.time()
t = datetime.time(8, 7, 23)

print(t.hour, t.minute, t.second, t.microsecond)


# NOTE: Output
# 8 7 23 0

```

##### `2.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import time

t = time.time()
print(time.gmtime())
time.sleep(2)
print(time.localtime())
time.sleep(3)
print(time.asctime())

# NOTE: Output
# time.struct_time(tm_year=2024, tm_mon=2, tm_mday=13, tm_hour=2, tm_min=23, tm_sec=20, tm_wday=1, tm_yday=44, tm_isdst=0)
# time.struct_time(tm_year=2024, tm_mon=2, tm_mday=13, tm_hour=9, tm_min=23, tm_sec=22, tm_wday=1, tm_yday=44, tm_isdst=0)
# Tue Feb 13 09:23:25 2024

```

##### `3.1.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import random

r = random.randint(0, 10)
print(r)
print(random.random())
a = ["Anna", "Betty", "Cathy", "Dorothy", "Eddy", "Freddy", "Iggy", "Hiccup"]
print(random.choice(a))
print(random.choices(a))

# NOTE: Output
# 0.9217484726341889
# Hiccup
# ['Betty']

```

##### `3.2.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import random

r = random.randint(0, 10)
random.seed()
print(random.random())

# NOTE: Output
# 0.6885266132671602

```

##### `4.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import statistics

gpas = [3.22, 3.99, 2.5, 2.4, 3.45, 3, 55, 3.5]
print(statistics.mean(gpas))
print(statistics.median(gpas))
print(statistics.mode(gpas))
print(statistics.stdev(gpas))
print(statistics.variance(gpas))

# NOTE: Output
# 9.6325
# 3.335
# 3.22
# 18.338758915788947
# 336.31007857142856

```

##### `5.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import math

print("sin(3) : ", math.sin(3))
print("sin(-3) : ", math.sin(-3))
print("sin(0) : ", math.sin(0))

# NOTE: Output
# sin(3) :  0.1411200080598672
# sin(-3) :  -0.1411200080598672
# sin(0) :  0.0

```

##### `6.1.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "this is string example....wow!!!"
print("Length of the string: ", len(str))

# NOTE: Output
# Length of the string:  32

```

##### `6.2.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "this is really a string example....wow!!!"
print("Max character: " + max(str))
num = (10, 20, 5, 9)
print("ตัวเลขที่มำกที่สุด ", max(num))

# NOTE: Output
# Max character: y
#  ตัวเลขที่มำกที่สุด  20

```

##### `6.3.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "THIS IS STRING EXAMPLE....WOW!!!"
print(str.lower())

# NOTE: Output
# this is string example....wow!!!

```


## Exam

##### `5-20-67.py`<br>
สร้าง: 20 ก.พ. 2567 เวลา 10:38<br>
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

##### `12-26-66.py`<br>
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

##### `test.py`<br>
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


## Exercise/1

##### `1.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 10:33<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 1.ให้เขียนโปรแกรมแสดง รหัสนักศึกษา ชื่อ-นามสกุล และจังหวัดที่อาศัยอยู่

student_id = "66143XXX"
full_name = "Faelayis"
province = "Chiang Mai"

print("รหัสนักศึกษา :", student_id)
print("ชื่อ-นามสกุล: ", full_name)
print("จังหวัดที่อาศัย: ", province)

```

##### `2.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 10:33<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 2.ให้เขียนคอมเม้นด้วยว่า #การแสดงอายุ แล้วใช้คาสั่งแสดงอายุของนักศึกษา

#การแสดงอายุ
age = 20

print("อายุ: ", age)

```

##### `3.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 10:33<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 3.ให้เขียนโปรแกรมหาพื้นที่สามเหลี่ยม เมื่อกาหนดให้ค่าฐานเท่ากับ 10 ค่าความสูงเท่ากับ 20

base = 10
height = 20

area_triangle = 0.5 * base * height

print("พื้นที่สามเหลี่ยม: ", area_triangle)

```

##### `4.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 10:33<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 4.ให้เขียนโปรแกรมหาพื้นที่สี่เหลี่ยมผืนผ้า เมื่อกาหนดให้ค่าความกว้างเท่ากับ 100 ความยาวเท่ากับ 400

width = 100
length = 400

area_rectangle = width * length

print("พื้นที่สี่เหลี่ยมผืนผ้า: ", area_rectangle)

```

##### `5.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 11:16<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 5.ให้ตอบคำถามต่อไปนี้ ว่าชื่อตัวแปรที่กำหนดถูกหรือผิด ถ้าผิดเพราะอะไร

# GPA           ถูก
# _ProgramPthon ถูก
# Num 123       ผิด ไม่ควรมีเว้นวรรคในชื่อตัวแปรและไม่ควรขึ้นต้นด้วยตัวเลข: Num123 ถูกต้อง
# email@cmru    ผิด ไม่สามารถใช้ @ เป็นส่วนหนึ่งของชื่อตัวแปรได้
# 64122456ID    ผิด ตัวแปรไม่ควรขึ้นต้นด้วยตัวเลข

```

##### `6.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 11:16<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 6.ให้เขียนโปรแกรมหาพื้นที่สามเหลี่ยม เมื่อกำหนดให้ ค่าฐานเท่ากับ 10 ค่าความสูงเท่ากับ 20 ให้แสดงชนิดตัวแปรผลลัพธ์พื้นที่ แล้วเปลี่ยนผลลัพธ์พื้นที่เป็นชนิด int

base = 10
height = 20
area = 0.5 * base * height

print("พื้นที่ของสามเหลี่ยมคือ:", area)
print("พื้นที่เป็นชนิด int คือ:", type(area))

```

##### `7.py`<br>
สร้าง: 14 พ.ย. 2566 เวลา 11:16<br>
แก้ไขล่าสุด: เวลา 11:28<br>

```py
# 7. ให้เขียนโปรแกรมหาพื้นที่สี่เหลี่ยมผืนผ้า เมื่อกำหนดให้ค่าความกว้างเท่ากับ 100 ความยาวเท่ากับ 400 ให้แสดงชนิดตัวแปรผลลัพธ์พื้นที่ เปลี่ยนผลลัพธ์พื้นที่เป็น str

width = 100
length = 400
area = width * length

print("พื้นที่ของสี่เหลี่ยมผืนผ้าคือ:", area)
print("พื้นที่เป็นชนิด area คือ:", type(area))

```


## Exercise/2

##### `1.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
grade = 3.75

print("Grade = ", grade)

```

##### `1.2.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
name = "Computer", "Departhment"

print(name[0] + " " + name[1])

```

##### `1.3.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
num1 = 10
num2 = 30

print(num1)
print(num2)

print("%d + %d = %d" % (num1, num2, num1 + num2))

```

##### `2.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
text = " Hello... \n Python Programming"

print(text)

```

##### `2.2.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
text = "ยินดีต้อนรับเข้าสู่"
text2 = '\t" โปรแกรมภาษาไพธอน "'

print(text)
print(text2)

```

##### `2.3.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
text = "ยินดีต้อนรับเข้าสู่"
text2 = '\t "โปรแกรมภาษาไพธอน"'

print("สวัสดี %s" % text)
print("***** %s *****" % text2)

```

##### `2.4.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
x = 10
y = 20
z = x + y

print("%d + %d = %d " % (x, y, z))

```

##### `2.5.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
dept = "Computer " "Department"

print(dept)

cm = "Chiang Mai"
r = "Rajabhat"
u = "University"

CMRU = cm + " " + r + " " + u

print(CMRU)

```

##### `3.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
grade = input("Enter Grade :")
section = input("Enter Section :")
subject = input("Enter Subject :")
avg = input("Enter avg :")

```

##### `3.1.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
name = input("Enter name :")
inName = input("Enter inName :")

print(name, inName)

```

##### `3.2.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
width = int(input("Enter Width :"))
length = int(input("Enter Length :"))

print(width * length)

```

##### `3.3.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:10<br>
```py
number1 = int(input("Enter Number 1 :"))
number2 = int(input("Enter Number 2 :"))

print(number1 + number2)

```

##### `4.py`<br>
สร้าง: 21 พ.ย. 2566 เวลา 11:35<br>
```py
# 1
N1 = int(input("Enter Number 1 :"))
N2 = int(input("Enter Number 2 :"))
sum = N1 + N2

print("Sum :", sum)

# 2
input2 = int(input("Enter Number :"))
print(2 * input2 + 1)

# 3
input3 = int(input("Enter Number :"))
print(2 * input3 + 1)

```


## Exercise/3

##### `1..py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    x = int(input("Enter X : "))

    if x == 0:
        print("ตัวเลขที่เป็นศูนย์ไม่สามารนำมาเป็นตัวหารได้")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

```

##### `1.1.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    Score = int(input("Enter Score : "))

    if Score >= 85:
        print(f"You Score = {Score} Very Good")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

print("Good Bye")

```

##### `2..py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    x = int(input("Enter X : "))
    y = int(input("Enter Y : "))

    if y == 0:
        print("ตัวเลขที่เป็นศูนย์ไม่สามารนำมาเป็นตัวหารได้")
    else:
        print(x / y)

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

print("Good Bye")

```

##### `2.1.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    Score = int(input("Enter Score : "))

    if 85 >= Score:
        print("Very Good")
    else:
        print("Sorry")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

```

##### `3.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
number = int(input("Enter an integer : "))

if number > 0:
    print("Positive Number")
elif number < 0:
    print("Negative Number")
else:
    print("Zero Number")

```

##### `4.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
def calculate(income):
    if income <= 5000:
        tax_rate = 0
    elif 5001 <= income <= 20000:
        tax_rate = 0.07
    elif 20001 <= income <= 50000:
        tax_rate = 0.10
    else:
        tax_rate = 0.15

    tax_amount = income * tax_rate
    net_income = income - tax_amount

    return tax_amount, net_income


try:
    salary = float(input("กรุณากรอกเงินเดือนพนักงาน: "))
    overtime_pay = float(input("กรุณากรอกค่าล่วงเวลา: "))

except ValueError:
    print("โปรดกรอกตัวเลขเท่านั้น")

total_income = salary + overtime_pay
tax_amount, net_income = calculate(total_income)

print(f"รายได้รวม: {total_income:.2f} บาท")
print(f"ภาษีที่ต้องจ่าย: {tax_amount:.2f} บาท")
print(f"รายได้สุทธิ: {net_income:.2f} บาท")

```

##### `5.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
def getGrade(score):
    if score >= 80 & score <= 100:
        return "A"
    elif score >= 70 & score <= 79:
        return "B"
    elif score >= 60 & score <= 69:
        return "C"
    elif score >= 50 & score <= 59:
        return "D"
    elif score >= 0 & score <= 49:
        return "F"


try:
    Score = int(input("Enter Score : "))

    if Score >= 100 & 0 <= Score:
        print("กรุณากรอกตัวเลขระหว่าง 0-100")
    else:
        print(f"Grade = {getGrade(Score)}")

except ValueError:
    print("กรุณากรอกตัวเลขที่ถูกต้อง")

```

##### `6.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
def add(x, y):
    return x + y


def subtract(x, y):
    return x - y


print("Menu:")
print("A.Add")
print("S.Subtract")

choice = input("\nEnter Choice (A/S): ").lower()

if choice in ("a", "s"):
    try:
        input1 = int(input("Enter first number : "))
        input2 = int(input("Enter second number : "))

        if choice == "a":
            result = add(input1, input2)
            print(f"\nResult : {input1} + {input2} = {result}")
        elif choice == "s":
            result = subtract(input1, input2)
            print(f"\nResult : {input1} - {input2} = {result}")

    except ValueError:
        print("ข้อมูลไม่ถูกต้องกรุณากรอกค่าตัวเลข")

else:
    print("ตัวเลือกไม่ถูกต้อง โปรดป้อน A หรือ S")

```

##### `7.py`<br>
สร้าง: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    Score = int(input("Enter Score : "))
    print("Very Good") if Score >= 80 else print("Sorry")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

```


## Exercise/5

##### `1.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
for x in range(5):
    print("name - last name")

```

##### `2.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
for number in range(1, 11, 2):
    print(number)

```

##### `3.1.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
sum = 0

for number in range(1, 51):
    sum = sum + number
    print(sum)

```

##### `3.2.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
for number in range(1, 11):
    print(number)

print("Good bye")

```

##### `3.3.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
for number in range(1, 13):
    print(f"{2 * number}")

```

##### `4.1.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
i = 1

while i <= 9:
    i += 1
    print("Happy Day")

print("Good bye")

```

##### `4.2.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
i = 9

while i > 0:
    i -= 1
    print("Happy Day")

print("Good bye")

```

##### `4.3.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
แก้ไขล่าสุด: เวลา 11:23<br>

```py
character = "n"

while character != "y":
    character = input("Enter y/n : ")

print("Good bye")

```

##### `4.4.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
sum = 0
number = 1

while number <= 50:
    sum += number
    number += 1

print(sum)

```

##### `4.5.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
แก้ไขล่าสุด: เวลา 11:14<br>

```py
sum = 0
count = 1

while count <= 5:
    try:
        number = int(input(f"Enter Number {count}: "))
        sum += number
        count += 1
    except ValueError:
        print("Please enter a number.")
    finally:
        avg = sum / 5
        print(f"Sum = {sum}, Avg = {avg}")

```

##### `5.1.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
```py
for x in range(1, 4):
    for i in range(1, x + 1):
        print(x, " ", i)

```

##### `5.2.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
แก้ไขล่าสุด: เวลา 11:14<br>

```py
for x in range(5):
    for i in range(x + 1):
        print("*", end=" ")
    print("")

```

##### `6.py`<br>
สร้าง: 19 ธ.ค. 2566 เวลา 11:09<br>
แก้ไขล่าสุด: เวลา 11:23<br>

```py
def multiplication_table(x):
    for number in range(1, 13):
        print(f"{x} x {number} = {x * number}")


try:
    multiplication_table(int(input("Enter Number : ")))
except ValueError:
    print("Please enter a number only.")

```


## Exercise/6.1

##### `1.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
a = [99, 5000.75, "Cat", True]

for item in a:
    print(item)

# output:
# 99
# 5000.75
# Cat
# True

```

##### `2.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
aeiou: list[str] = ["a", "e", "I", "o", "u"]

for x in aeiou:
    print(x)

# a
# e
# I
# o
# u

```

##### `3.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
num: list[int] = [10, 20, 30, 40, 50]

print(num)

num = [i * 2 for i in num]
print(num)

# Output:
# [10, 20, 30, 40, 50]
# [20, 40, 60, 80, 100]

```

##### `4.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
program: list[str] = ["Python", "C", "PHP", "ASP"]

if "Python" in program:
    print("Python อยู่ในลิสต์")
else:
    print("Python ไม่อยู่ในลิสต์")

# outout: Python อยู่ในลิสต์

```

##### `5.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
numbers: list[int] = [99, 10, 20, 50, 15]

length = len(numbers)
print(length)

maximum = max(numbers)
print(maximum)

minimum = min(numbers)
print(minimum)

total = sum(numbers)
print(total)

del numbers[0]
print(numbers)

# outout:
# len : 5
# max : 99
# min : 10
# sum : 194
# del 0 : [10, 20, 50, 15]

```

##### `6.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
p = ["Python", "C", "PHP", "ASP"]

p.append("Java")
print(p)

count = p.count("Python")
print(count)

p.remove("Python")
print(p)

p.sort()
print(p)

p.reverse()
print(p)

p.clear()
print(p)

p.insert(0, "TypeScript")
print(p)

# output  :
# append : ['Python', 'C', 'PHP', 'ASP', 'Java']
# count  : 1
# remove : ['C', 'PHP', 'ASP', 'Java']
# sort   : ['ASP', 'C', 'Java', 'PHP']
# reverse: ['PHP', 'Java', 'C', 'ASP']
# clear  : []
# insert : ['TypeScript']

```

##### `7.1.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
a = (10, 2000.75, "Cat", "One")
print(a[0], a[1], a[2], a[3])
print(a)

# 10 2000.75 Cat One
# (10, 2000.75, 'Cat', 'One')

```

##### `7.2.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
L1 = ["a", "e", "i", "o", "u"]
my_tuple = tuple(L1)

print(my_tuple)
print(my_tuple[-5])
print(my_tuple[-4])
print(my_tuple[-3])
print(my_tuple[-2])
print(my_tuple[-1])
print("Good Bye")

# output:
# a
# e
# i
# o
# u
# Good Bye

```

##### `7.3.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
L1 = ["a", "e", "i", "o", "u"]
my_tuple = tuple(L1)

for i in my_tuple:
    print(i)

type(L1)
type(my_tuple)

#  output:
#  a
#  e
#  i
#  o
#  u

```

##### `8.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
x = ("apple", "banana", "cherry")
y = list(x)
y[1] = "kiwi"  # type: ignore
x = tuple(y)
print(x)

# output: ('apple', 'kiwi', 'cherry')

```

##### `9.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
A = (10, 20, 30, 40, 50)
B = ("a", "b", "c", "d", "e")
C = A + B
print(C)

# output: (10, 20, 30, 40, 50, 'a', 'b', 'c', 'd', 'e')

```

##### `10.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
X = ("Hello", "Python")
Y = X * 3
print(Y)

# output : ('Hello', 'Python', 'Hello', 'Python', 'Hello', 'Python')

```

##### `11.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:56<br>
อัปเดต: 23 ม.ค. 2567 เวลา 11:12<br>
```py
# ตัวเลขไทย
tp_thai_digits = ("๐", "๑", "๒", "๓", "๔", "๕", "๖", "๗", "๘", "๙")

# คำอ่านตัวเลขไทย
tp_digit_words = (
    "ศูนย์",
    "หนึ่ง",
    "สอง",
    "สาม",
    "สี่",
    "ห้า",
    "หก",
    "เจ็ด",
    "แปด",
    "เก้า",
)

# รับปีที่ผู้ใช้ป้อนเข้ามา
year = input("Enter a year: ")

# แปลงปีเป็นตัวเลขไทย
thai_year = "".join(tp_thai_digits[int(digit)] for digit in year)
print(f"Thai year: {thai_year}")

# แปลงปีเป็นคำอ่านตัวเลขไทย
thai_year_words = " ".join(tp_digit_words[int(digit)] for digit in year)
print(f"Thai year words: {thai_year_words}")

```


## Exercise/6.2

##### `1.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
txt = "The best things in life are free!"

if "free" in txt:
    print(("Yes, 'free' is present"))
else:
    print(("No, 'free' is not present"))

# NOTE: Output
# Yes, 'free' is present

```

##### `2.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
fruits = ["apple", "banana", "Cherry"]
x, y, z = fruits

print(x, y, z)

# NOTE: Output
# apple banana Cherry

```

##### `3.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
x = {10, 20, 30, 40, 50}
y = {1, "One", 2, "two"}
l1 = ("a", "e", "i", "o", "u")
z = set(l1)

for i in x:
    print(i, end=" ")
print("\n")

for i in y:
    print(i, end=" ")
print("\n")

for i in z:
    print(i, end=" ")

# NOTE: Output
# 50 20 40 10 30
# two 1 2 One
# o e u a i

```

##### `4.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
setA = set("abracadabra")
setB = set("alacazam")
setC = set("112768730893488746249")

print(setA)
print(setB)
print(setC)

# NOTE: Output
# {'d', 'r', 'c', 'b', 'a'}
# {'z', 'l', 'm', 'c', 'a'}
# {'1', '6', '9', '3', '4', '7', '2', '0', '8'}

```

##### `5.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
x = {10, 20, 30, 40, 50}
print("จ ำนวนข้อมูลในเซตทั้งหมด คือ ", len(x))
print("จ ำนวนตัวเลขในเซตที่มีค่ำมำกที่สุด คือ ", max(x))
print("จ ำนวนตัวเลขในเซตที่มีค่ำน้อยที่สุด คือ ", min(x))
print("ผลรวมข้อมูลทั้งหมดในเซต คือ ", sum(x))
print("ชนิดของตัวแปร x คือ ", type(x))

# NOTE: Output
# จำนวนข้อมูลในเซตทั้งหมด คือ 5
# จำนวนตัวเลขในเซตที่มีค่ำมำกที่สุด คือ 50
# จำนวนตัวเลขในเซตที่มีค่ำน้อยที่สุด คือ 10
# ผลรวมข้อมูลทั้งหมดในเซต คือ 150
# ชนิดของตัวแปร x คือ <class 'set'>

```

##### `6.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
s1 = {1, 3, 5, 7, 9}

s1.add(10)
print(s1)

s1.remove(3)
print(s1)

s1.difference_update({1, 5})
print(s1)

s1.clear()
print(s1)

# NOTE: Output
# {1, 3, 5, 7, 9, 10}
# {1, 5, 7, 9, 10}
# {7, 9, 10}
# set()

```

##### `7.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
s1 = {1, 2, 3, 4, 5}
s2 = {4, 5, 6, 7, 8}

print("Union:", s1.union(s2))
print("Intersection:", s1.intersection(s2))
print("Difference:", s1.difference(s2))

# NOTE: Output
# Union: {1, 2, 3, 4, 5, 6, 7, 8}
# Intersection: {4, 5}
# Difference: {1, 2, 3}

```

##### `8.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}

for key in dict:
    print(key)
print("-" * 20)

# NOTE: Output
# 1
# 2
# 3
# 4
# 5
# --------------------

```

##### `9.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}

for k in dict1.keys():
    print(dict1[k])
print("-" * 20)

for k in dict1:
    print(dict1[k])

# NOTE: Output
# One
# Two
# Three
# Four
# Five
# --------------------
# One
# Two
# Three
# Four
# Five

```

##### `10.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}
d1 = dict1.values()

for i in d1:
    print(i)

# NOTE: Output
# One
# Two
# Three
# Four
# Five

```

##### `11.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}

for i, j in dict1.items():
    print(i, j)

# NOTE: Output
# 1 One
# 2 Two
# 3 Three
# 4 Four
# 5 Five

```

##### `12.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}
dict2 = dict1.copy()
print(dict2)
dict3 = dict(dict1)
print(dict3)

# NOTE: Output
# dict2 : {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 5: 'Five'}
# dict3 : {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 5: 'Five'}

```

##### `13.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}
print(dict1.get(3))
dict1.pop(3)
print(dict1)
dict1.popitem()
dict1.update({1: "หนึ่ง"})
print(dict1)
dict1.clear()
print(dict1)

# NOTE: Output
# Three
# {1: 'One', 2: 'Two', 4: 'Four', 5: 'Five'}
# {1: 'หนึ่ง', 2: 'Two', 4: 'Four'}
# {}

```

##### `14.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
แก้ไขล่าสุด: เวลา 11:27<br>

```py
students = {
    525: "รวิพล ธูปทอง",
    527: "รักไทย ใจมิภักดิ์",
    432: "พชรพล ฮะกาศ",
    492: "กิตติพงษ์ มะณีใส",
    513: "สาริษฐ์ ดุลย์มา",
}

# รับคีย์ทั้งหมด
keys = list(students.keys())


# Functions แสดงรหัสนักศึกษาและชื่อทุกคน
def ShowAllStudent(*args) -> None:
    """
    แสดงรายชื่อนักเรียนทั้งหมดหรือรายชื่อที่ระบุ (ถ้ามี) พร้อมรหัสนักเรียน

    Args:
       *args: รายชื่อนักเรียนที่ต้องการแสดง (ถ้ามี)

    """

    def getIndex(key) -> int:
        return list(students).index(key) + 1

    if args:
        for key in args:
            if key in students:
                print(f"{getIndex(key)}.[{key}] {students[key]}")
        print()
    else:
        for key, name in students.items():
            print(f"{getIndex(key)}.[{key}] {name}")
        print()


# แสดงรหัสนักศึกษาและชื่อทุกคน
ShowAllStudent()

# แก้ไขชื่อเพื่อนลำดับที่ 3 เป็นชื่อเล่น
students[keys[2]] = "พฤกษ์"

# แสดงชื่อเพื่อนลำดับที่ 3
ShowAllStudent(keys[2])

# ลบเพื่อนลำดับที่ 4 ออก
del students[keys[3]]

# แสดงข้อมูลเพื่อนที่เหลือ
ShowAllStudent()

# ลบข้อมูลทั้งหมด
students.clear()

# แสดงผลลัพธ์
ShowAllStudent()

# NOTE: Output
# 1.[525] รวิพล ธูปทอง
# 2.[527] รักไทย ใจมิภักดิ์
# 3.[432] พชรพล ฮะกาศ
# 4.[492] กิตติพงษ์ มะณีใส
# 5.[513] สาริษฐ์ ดุลย์มา

# 3.[432] พฤกษ์

# 1.[525] รวิพล ธูปทอง
# 2.[527] รักไทย ใจมิภักดิ์
# 3.[432] พฤกษ์
# 4.[513] สาริษฐ์ ดุลย์มา

```


## Exercise/7.1

##### `1.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def DisplayNumber(num):
    for i in range(1, num + 1):
        print(i)


DisplayNumber(1)

# NOTE: Output
# 1

```

##### `2.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def SumNumber(number):
    sum = 0
    for i in range(1, number + 1):
        sum = sum + i
    print("ผลรวมของตัวเลข 1 ถึง %d เท่ากับ %d " % (number, sum))


SumNumber(5)

# NOTE: Output
# ผลรวมของตัวเลข 1 ถึง 5 เท่ากับ 15

```

##### `3.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
options = {"A": "การบวกเลข", "S": "การลบเลข", "M": "การคูณเลข"}


def add(number1, number2):
    print(f"Result: {number1 + number2}")


def sub(number1, number2):
    print(f"Result: {number1 - number2}")


def mul(number1, number2):
    print(f"Result: {number1 * number2}")


def showMenu():
    print("*******************")
    print("     Main Menu     ")
    print("*******************")
    for key, value in options.items():
        print(f" {key} - {value}")
    print("*******************\n")


def createInputChoice():
    choice = input("Enter your choice: ")

    if choice.upper() in options:
        print(f"You selected: {options[choice.upper()]}\n")
        return choice.upper()
    else:
        print("Invalid choice! \n")


def createInputNumber():
    number1 = int(input("Enter First Number: "))
    number2 = int(input("Enter Second Number: "))
    return number1, number2


showMenu()
choice = createInputChoice()


if choice == "A":
    add(*createInputNumber())
elif choice == "S":
    sub(*createInputNumber())
elif choice == "M":
    mul(*createInputNumber())

print("\n")

```

##### `4.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def Add(number1, number2) -> None:
    sum = int(number1) + int(number2)
    print("ผลลัพธ์ของการบวกเลข เท่ากับ ", sum)


x = input("ป้อนตัวเลขที่ 1: ")
y = input("ป้อนตัวเลขที่ 2: ")

Add(x, y)

# NOTE: Input
# ป้อนตัวเลขที่ 1: 1
# ป้อนตัวเลขที่ 2: 1

# NOTE: Output
# ผลลัพธ์ของการบวกเลข เท่ากับ  2

```

##### `5.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def multiplication_table(n):
    for i in range(1, 13):
        print(n, "x", i, "=", n * i)
    print("\n")


multiplication_table(int(input("Enter a number: ")))

```

##### `6.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def fNum(num):
    if num % 2 == 0:
        print("เลขคู่")
    else:
        print("เลขคี่")


fNum(10)
# NOTE: Parameter 10
# Output เลขคู่

fNum(7)
# NOTE: Parameter 7
# Output เลขคี่

```

##### `7.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def calculate_triangle_area(base, height):
    area = 0.5 * base * height
    return area


base = float(input("Enter base : "))
height = float(input("Enter height : "))

triangle_area = calculate_triangle_area(base, height)
print("The area is: ", triangle_area)

# NOTE: Input
# Enter base : 10
# Enter height : 10

# NOTE: Output
# The area is : 50.0

```

##### `8.1.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def sumA(*n) -> None:
    a = 0
    for x in n:
        a += x
    print(a)


sumA(3, 4, 12, 1)
sumA(10, 20, 30)

# NOTE: Output
# 20
# 60

```

##### `8.2.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def printkv(**kv):
    print(type(kv))
    print(kv)


printkv(name="Manaka Mukaido", age=14, sex="หญิง")

# NOTE: Output
# <class 'dict'>
# {'name': 'Manaka Mukaido', 'age': 14, 'sex': 'หญิง'}

```

##### `9.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def sumA(*n):
    a = 0
    for x in n:
        a += x
    return a


numbers = [int(num) for num in input("Enter numbers: ").split()]
result = sumA(*numbers)

print("Sum:", result)
print("Average:", result / len(numbers))
print()

```

##### `10.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def primeNum(num):
    if num % 2 == 0:
        return "เลขคู่"
    else:
        return "เลขคี่"


x = int(input("ป้อนตัวเลข: "))
result = primeNum(x)

print("ตัวเลขที่ป้อนเป็น ", result)

# NOTE: Input
# ป้อนตัวเลขที่ : 14

# NOTE: Output
# ตัวเลขที่ป้อนเป็นเลขคู่

```

##### `11.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
def Tri(b, h):
    Area = 0.5 * b * h
    return Area


x = int(input("ป้อนตัวเลข: "))
y = int(input("ป้อนตัวเลข: "))
result = Tri(x, y)

print("พื้นที่สามเหลี่ยมเท่ากับ ", result)

# NOTE: Input
# ป้อนตัวเลข : 10
# ป้อนตัวเลข : 50

# NOTE: Output
# พื้นที่สามเหลี่ยมเท่ากับ 250.0

```

##### `12.py`<br>
สร้าง: 6 ก.พ. 2567 เวลา 10:57<br>
แก้ไขล่าสุด: เวลา 12:07<br>

```py
options = {"A": "การบวกเลข", "S": "การลบเลข", "M": "การคูณเลข"}


def add(number1, number2):
    return number1 + number2


def sub(number1, number2):
    return number1 - number2


def mul(number1, number2):
    return number1 * number2


def showMenu():
    print("*******************")
    print("     Main Menu     ")
    print("*******************")
    for key, value in options.items():
        print(f" {key} - {value}")
    print("*******************\n")


def createInputChoice():
    choice = input("Enter your choice: ")

    if choice.upper() in options:
        print(f"You selected: {options[choice.upper()]}\n")
        return choice.upper()
    else:
        print("Invalid choice! \n")


def createInputNumber():
    number1 = int(input("Enter First Number: "))
    number2 = int(input("Enter Second Number: "))
    return number1, number2


showMenu()
choice = createInputChoice()


if choice == "A":
    result = add(*createInputNumber())
    print("Result: ", result)
elif choice == "S":
    result = sub(*createInputNumber())
    print("Result: ", result)
elif choice == "M":
    result = mul(*createInputNumber())
    print("Result: ", result)

print("\n")

```


## Exercise/7.2

##### `1.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
from datetime import date


def display_birthdate(day, month, year):
    birthdate = date(year, month, day)
    formatted_date = birthdate.strftime("%d/%m/%Y")
    print("Your birthday is :", formatted_date)


display_birthdate(1, 1, 1999)

# NOTE: Output
# Your birthday is : 1/1/1999

```

##### `2.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import datetime

birth_date = input("Enter your birth date (dd/mm/yyyy) : ")
day, month, year = map(int, birth_date.split("/"))
birth_date = datetime.date(year, month, day)

print("Your birthday is : ", birth_date)

# NOTE: Input
# Enter your birthday (dd/mm/yyyy) : 1/1/1999

# NOTE: Output
# Your birthday is : 1999-01-01

```

##### `3.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import datetime

numbers = [int(num) for num in input("Enter Time (0 0 0) : ").split()[:3]]

if len(numbers) < 3:
    numbers += [0] * (3 - len(numbers))


def create_time(hours, minutes, seconds):
    time = datetime.time(hours, minutes, seconds)
    return time


print(f"Create Custom Time : {create_time(*numbers)}")

# NOTE: Input
# Enter Time (0 0 0) : 9 52 0

# NOTE: Output
# Create Custom Time : 09:52:00

```

##### `4.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import math

number = float(input("กรุณาระบุตัวเลข: "))

sin_value = math.sin(number)
cos_value = math.cos(number)
tan_value = math.tan(number)

print(f"ค่า sin = {sin_value}")
print(f"ค่า cos = {cos_value}")
print(f"ค่า tan = {tan_value}")

# NOTE: Input
# กรุณาระบุตัวเลข: 14

# NOTE: Output
# ค่า sin = 0.9906073556948704
# ค่า cos = 0.1367372182078336
# ค่า tan = 7.2446066160948055

```

##### `5.py`<br>
สร้าง: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import random

choices = {"p": "กระดาษ", "s": "กรรไกร", "h": "ค้อน"}
player_score = 0
computer_score = 0

print("(P) กระดาษ, (S) กรรไกร, (H) ค้อน")

while player_score < 3 and computer_score < 3:
    computer_choice = random.choice(list(choices.keys()))
    player_input = input("ป้อนตัวอักษร : ").lower()

    print("คอมพิวเตอร์สุ่มได้ ", choices[computer_choice])
    print()

    if choices[computer_choice] == choices[player_input]:
        print("เสมอ")
    elif choices[computer_choice] == "p" and choices[player_input] == "s":
        print("ผู้เล่นชนะ")
        player_score += 1
    elif choices[computer_choice] == "h" and choices[player_input] == "p":
        print("ผู้เล่นชนะ")
        player_score += 1
    elif choices[computer_choice] == "s" and choices[player_input] == "h":
        print("ผู้เล่นชนะ")
        player_score += 1
    else:
        print("คอมพิวเตอร์ชนะ")
        computer_score += 1
    print()

if player_score == 3:
    print(f"ผู้เล่นชนะเกม! {player_score}:{computer_score}")
else:
    print(f"คอมพิวเตอร์ชนะเกม! {computer_score}:{player_score}")
print()

```
