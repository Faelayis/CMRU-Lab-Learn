`1..py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    x = int(input("Enter X : "))

    if x == 0:
        print("ตัวเลขที่เป็นศูนย์ไม่สามารนำมาเป็นตัวหารได้")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

```
`1.1.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    Score = int(input("Enter Score : "))

    if Score >= 85:
        print(f"You Score = {Score} Very Good")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

print("Good Bye")

```
`2..py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
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
`2.1.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
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
`3.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
```py
number = int(input("Enter an integer : "))

if number > 0:
    print("Positive Number")
elif number < 0:
    print("Negative Number")
else:
    print("Zero Number")

```
`4.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
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
`5.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
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
`6.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
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
`7.py`<br>
Create: 28 พ.ย. 2566 เวลา 11:15<br>
```py
try:
    Score = int(input("Enter Score : "))
    print("Very Good") if Score >= 80 else print("Sorry")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

```
