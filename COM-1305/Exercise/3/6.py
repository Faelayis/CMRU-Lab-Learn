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
