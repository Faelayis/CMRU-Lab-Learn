def find_zodiac(year):
    zodiac = [
        "ขวด-หนู",
        "ฉลู-วัว",
        "ขาล-เสือ",
        "เถาะ-กระต่าย",
        "มะโรง-งูใหญ่",
        "มะเส็ง-งูเล็ก",
        "มะเมีย-ม้า",
        "มะแม-แพะ",
        "วอก-ลิง",
        "ระกา-ไก่",
        "จอ-สุนัข",
        "กุน-หมู",
    ]

    index = (year + 5) % 12
    return zodiac[index]


def find_year(year):
    y = year - 543
    if y % 400 == 0:
        return True
    else:
        if y % 4 == 0 and y % 100 != 0:
            return True
    return False


def main():
    while True:
        year = input("ป้อนปี: ")

        if len(year) != 4 or not year.isdigit():
            print("กรุณากรอกปีที่เป็นตัวเลข 4 หลัก ")
        else:
            year = int(year)
            break

    print(f"ปี {year} คือปี {find_zodiac(year)}")

    if find_year(year):
        print("ไม่เป็นปีอธิกสุรทิ")
    else:
        print("เป็นปีอธิกสุรทิ")


main()
