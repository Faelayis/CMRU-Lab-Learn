# ตัวเลขไทย
tp_thai_digits = ("๐", "๑", "๒", "๓", "๔", "๕", "๖", "๗", "๘", "๙")

# คำอ่านตัวเลขไทย
tp_digit_words = (
    "ศูนย์",
    "หนึ่ง",
    "สอง",
    "สาม",
    "สี่",
    "ห้า",
    "หก",
    "เจ็ด",
    "แปด",
    "เก้า",
)

# รับปีที่ผู้ใช้ป้อนเข้ามา
year = input("Enter a year: ")

# แปลงปีเป็นตัวเลขไทย
thai_year = "".join(tp_thai_digits[int(digit)] for digit in year)
print(f"Thai year: {thai_year}")

# แปลงปีเป็นคำอ่านตัวเลขไทย
thai_year_words = " ".join(tp_digit_words[int(digit)] for digit in year)
print(f"Thai year words: {thai_year_words}")
