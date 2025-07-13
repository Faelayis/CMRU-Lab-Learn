`1.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
for x in range(5):
    print("name - last name")

```
`2.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
for number in range(1, 11, 2):
    print(number)

```
`3.1.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
sum = 0

for number in range(1, 51):
    sum = sum + number
    print(sum)

```
`3.2.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
for number in range(1, 11):
    print(number)

print("Good bye")

```
`3.3.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
for number in range(1, 13):
    print(f"{2 * number}")

```
`4.1.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
i = 1

while i <= 9:
    i += 1
    print("Happy Day")

print("Good bye")

```
`4.2.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
i = 9

while i > 0:
    i -= 1
    print("Happy Day")

print("Good bye")

```
`4.3.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
Last edited: Time 11:23<br>

```py
character = "n"

while character != "y":
    character = input("Enter y/n : ")

print("Good bye")

```
`4.4.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
sum = 0
number = 1

while number <= 50:
    sum += number
    number += 1

print(sum)

```
`4.5.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
Last edited: Time 11:14<br>

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
`5.1.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
```py
for x in range(1, 4):
    for i in range(1, x + 1):
        print(x, " ", i)

```
`5.2.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
Last edited: Time 11:14<br>

```py
for x in range(5):
    for i in range(x + 1):
        print("*", end=" ")
    print("")

```
`6.py`<br>
Create: 19 ธ.ค. 2566 time 11:09<br>
Last edited: Time 11:23<br>

```py
def multiplication_table(x):
    for number in range(1, 13):
        print(f"{x} x {number} = {x * number}")


try:
    multiplication_table(int(input("Enter Number : ")))
except ValueError:
    print("Please enter a number only.")

```
