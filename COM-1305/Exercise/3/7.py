try:
    Score = int(input("Enter Score : "))
    print("Very Good") if Score >= 80 else print("Sorry")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")
