try:
    x = int(input("Enter X : "))

    if x == 0:
        print("ตัวเลขที่เป็นศูนย์ไม่สามารนำมาเป็นตัวหารได้")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")
