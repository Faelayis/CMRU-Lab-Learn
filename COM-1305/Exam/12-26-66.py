month = {
    1: "มกราคม",
    2: "กุมภาพันธ์",
    3: "มีนาคม",
    4: "เมษายน",
    5: "พฤษภาคม",
    6: "มิถุนายน",
    7: "กรกฎาคม",
    8: "สิงหาคม",
    9: "กันยายน",
    10: "ตุลาคม",
    11: "พฤศจิกายน",
    12: "ธันวาคม",
}

month_number = int(input("Enter Month Number : "))

if month_number in month:
    print(f"เดือนที่ {month_number} คือ {month[month_number]}")
else:
    print("เลขเดือนไม่ถูกต้อง")
