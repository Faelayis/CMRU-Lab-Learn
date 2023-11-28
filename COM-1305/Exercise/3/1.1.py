try:
    Score = int(input("Enter Score : "))

    if Score >= 85:
        print(f"You Score = {Score} Very Good")

except ValueError:
    print("กรุณากรอกจำนวนเต็มที่ถูกต้อง")

print("Good Bye")
