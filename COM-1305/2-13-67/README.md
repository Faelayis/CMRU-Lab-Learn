`1.1.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
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
`1.2.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import datetime

t = datetime.time()
t = datetime.time(8, 7, 23)

print(t.hour, t.minute, t.second, t.microsecond)


# NOTE: Output
# 8 7 23 0

```
`2.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
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
`3.1.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
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
`3.2.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
```py
import random

r = random.randint(0, 10)
random.seed()
print(random.random())

# NOTE: Output
# 0.6885266132671602

```
`4.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
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
`5.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
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
`6.1.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "this is string example....wow!!!"
print("Length of the string: ", len(str))

# NOTE: Output
# Length of the string:  32

```
`6.2.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "this is really a string example....wow!!!"
print("Max character: " + max(str))
num = (10, 20, 5, 9)
print("ตัวเลขที่มำกที่สุด ", max(num))

# NOTE: Output
# Max character: y
#  ตัวเลขที่มำกที่สุด  20

```
`6.3.py`<br>
Create: 13 ก.พ. 2567 เวลา 11:39<br>
```py
str = "THIS IS STRING EXAMPLE....WOW!!!"
print(str.lower())

# NOTE: Output
# this is string example....wow!!!

```
