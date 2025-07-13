`1.py`<br>
สร้าง: 13 ก.ค. 2568 เวลา 23:42<br>
```py
num_books = int(input("How many books: "))
total_price = float(input("How much: "))

if num_books >= 2 and total_price > 300:
    discount = total_price * 0.10
    total_price -= discount

print(f"You have to pay {int(total_price)} bath.")
```
`2.py`<br>
สร้าง: 13 ก.ค. 2568 เวลา 23:42<br>
```py
print('Enter number:')
x = input()

for i in range(len(x)-1,-1,-1):
  print(x[i])

```
`3.py`<br>
สร้าง: 13 ก.ค. 2568 เวลา 23:42<br>
```py
text = """
Python is a high-level, interpreted, general-purpose programming language. Its design philosophy
emphasizes code readability with the use of significant indentation.

Python is dynamically-typed and garbage-collected. It supports multiple programming paradigms,
including structured (particularly procedural), object-oriented and functional programming.
It is often described as a 'batteries included' language due to its comprehensive standard library.

Guido van Rossum began working on Python in the late 1980s as a successor to the ABC
programming language and first released it in 1991 as Python 0.9.0. Python 2.0 was released
in 2000 and introduced new features such as list comprehensions, cycle-detecting garbage
collection, reference counting, and Unicode support. Python 3.0, released in 2008, was a major
revision that is not completely backward-compatible with earlier versions. Python 2 was discontinued
with version 2.7.18 in 2020.
"""

print(text.count("Python"))
```
`4.py`<br>
สร้าง: 13 ก.ค. 2568 เวลา 23:42<br>
```py
list = ['abc', 'xyz', 'aba', '1221', 'กนก','dawdad']
result = []

for x in list:
  if len(x) >= 2 and x[0] == x[-1]:
    result.append(x)

print(result)
print("Expected Result :" , len(result))
```
`5.py`<br>
สร้าง: 13 ก.ค. 2568 เวลา 23:42<br>
```py
text = "w3resource"
char_count = {}

for char in text:
    char_count[char] = char_count.get(char, 0) + 1

print(char_count)
```
