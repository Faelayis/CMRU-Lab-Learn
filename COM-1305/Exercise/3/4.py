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
