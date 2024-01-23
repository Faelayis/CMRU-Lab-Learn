students = {
    525: "รวิพล ธูปทอง",
    527: "รักไทย ใจมิภักดิ์",
    432: "พชรพล ฮะกาศ",
    492: "กิตติพงษ์ มะณีใส",
    513: "สาริษฐ์ ดุลย์มา",
}

# รับคีย์ทั้งหมด
keys = list(students.keys())


# Functions แสดงรหัสนักศึกษาและชื่อทุกคน
def ShowAllStudent(*args):
    """
    แสดงรายชื่อนักเรียนทั้งหมดหรือรายชื่อที่ระบุ (ถ้ามี) พร้อมรหัสนักเรียน

    Args:
       *args: รายชื่อนักเรียนที่ต้องการแสดง (ถ้ามี)

    """

    def getIndex(key):
        return list(students).index(key) + 1

    if args:
        for key in args:
            if key in students:
                print(f"{getIndex(key)}.[{key}] {students[key]}")
        print()
    else:
        for key, name in students.items():
            print(f"{getIndex(key)}.[{key}] {name}")
        print()


# แสดงรหัสนักศึกษาและชื่อทุกคน
ShowAllStudent()

# แก้ไขชื่อเพื่อนลำดับที่ 3 เป็นชื่อเล่น
students[keys[2]] = "พฤกษ์"

# แสดงชื่อเพื่อนลำดับที่ 3
ShowAllStudent(keys[2])

# ลบเพื่อนลำดับที่ 4 ออก
del students[keys[3]]

# แสดงข้อมูลเพื่อนที่เหลือ
ShowAllStudent()

# ลบข้อมูลทั้งหมด
students.clear()

# แสดงผลลัพธ์
ShowAllStudent()

# NOTE: Output
# 1.[525] รวิพล ธูปทอง
# 2.[527] รักไทย ใจมิภักดิ์
# 3.[432] พชรพล ฮะกาศ
# 4.[492] กิตติพงษ์ มะณีใส
# 5.[513] สาริษฐ์ ดุลย์มา

# 3.[432] พฤกษ์

# 1.[525] รวิพล ธูปทอง
# 2.[527] รักไทย ใจมิภักดิ์
# 3.[432] พฤกษ์
# 4.[513] สาริษฐ์ ดุลย์มา
