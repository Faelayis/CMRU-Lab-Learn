def Tri(b, h):
    Area = 0.5 * b * h
    return Area


x = int(input("ป้อนตัวเลข: "))
y = int(input("ป้อนตัวเลข: "))
result = Tri(x, y)

print("พื้นที่สามเหลี่ยมเท่ากับ ", result)

# NOTE: Input
# ป้อนตัวเลข : 10
# ป้อนตัวเลข : 50

# NOTE: Output
# พื้นที่สามเหลี่ยมเท่ากับ 250.0
