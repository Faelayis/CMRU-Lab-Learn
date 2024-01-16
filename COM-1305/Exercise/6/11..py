from importlib import import_module

lib = import_module("11_lib")

# รับปีที่ผู้ใช้ป้อนเข้ามา
year = input("Enter a year: ")

# แปลงปีเป็นตัวเลขไทย
thai_year = "".join(lib.tp_thai_digits[int(digit)] for digit in year)
print(f"Thai year: {thai_year}")

# แปลงปีเป็นคำอ่านตัวเลขไทย
thai_year_words = " ".join(lib.tp_digit_words[int(digit)] for digit in year)
print(f"Thai year words: {thai_year_words}")
