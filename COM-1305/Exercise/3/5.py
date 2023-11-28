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
