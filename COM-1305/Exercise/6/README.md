`1.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`10.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
X = ("Hello", "Python")
Y = X * 3
print(Y)

# output : ('Hello', 'Python', 'Hello', 'Python', 'Hello', 'Python')

```
`11..py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
from importlib import import_module

lib = import_module("11_lib")

# รับปีที่ผู้ใช้ป้อนเข้ามา
year = input("Enter a year: ")

# แปลงปีเป็นตัวเลขไทย
thai_year = "".join(lib.tp_thai_digits[int(digit)] for digit in year)
print(f"Thai year: {thai_year}")

# แปลงปีเป็นคำอ่านตัวเลขไทย
thai_year_words = " ".join(lib.tp_digit_words[int(digit)] for digit in year)
print(f"Thai year words: {thai_year_words}")

```
`11_lib.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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

```
`2.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`3.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
num: list[int] = [10, 20, 30, 40, 50]

print(num)

num = [i * 2 for i in num]
print(num)

# Output:
# [10, 20, 30, 40, 50]
# [20, 40, 60, 80, 100]

```
`4.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
program: list[str] = ["Python", "C", "PHP", "ASP"]

if "Python" in program:
    print("Python อยู่ในลิสต์")
else:
    print("Python ไม่อยู่ในลิสต์")

# outout: Python อยู่ในลิสต์

```
`5.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`6.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`7.1.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
a = (10, 2000.75, "Cat", "One")
print(a[0], a[1], a[2], a[3])
print(a)

# 10 2000.75 Cat One
# (10, 2000.75, 'Cat', 'One')

```
`7.2.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`7.3.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
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
`8.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
x = ("apple", "banana", "cherry")
y = list(x)
y[1] = "kiwi"  # type: ignore
x = tuple(y)
print(x)

# output: ('apple', 'kiwi', 'cherry')

```
`9.py`<br>
สร้าง: 16 ม.ค. 2567 เวลา 11:52<br>
```py
A = (10, 20, 30, 40, 50)
B = ("a", "b", "c", "d", "e")
C = A + B
print(C)

# output: (10, 20, 30, 40, 50, 'a', 'b', 'c', 'd', 'e')

```
