def primeNum(num):
    if num % 2 == 0:
        return "เลขคู่"
    else:
        return "เลขคี่"


x = int(input("ป้อนตัวเลข: "))
result = primeNum(x)

print("ตัวเลขที่ป้อนเป็น ", result)
