try:
    Score = int(input("Enter Score : "))

    if 85 >= Score:
        print("Very Good")
    else:
        print("Sorry")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")
