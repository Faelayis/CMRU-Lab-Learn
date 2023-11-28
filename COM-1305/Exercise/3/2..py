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
