`2.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
```py
fruits = ["apple", "banana", "Cherry"]
x, y, z = fruits

print(x, y, z)

# NOTE: Output
# apple banana Cherry

```
`3.py`<br>
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
`4.py`<br>
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
`5.py`<br>
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
`6.py`<br>
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
`7.py`<br>
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
`1.py`<br>
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
`8.py`<br>
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
`9.py`<br>
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
`10.py`<br>
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
`11.py`<br>
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
`12.py`<br>
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
`13.py`<br>
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
`14.py`<br>
สร้าง: 23 ม.ค. 2567 เวลา 11:12<br>
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
def ShowAllStudent(*args):
    """
    แสดงรายชื่อนักเรียนทั้งหมดหรือรายชื่อที่ระบุ (ถ้ามี) พร้อมรหัสนักเรียน

    Args:
       *args: รายชื่อนักเรียนที่ต้องการแสดง (ถ้ามี)

    """

    def getIndex(key):
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
