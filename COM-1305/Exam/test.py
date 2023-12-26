text = input("ป้อนสัญลักษณ์พิเศษ : ")
num = int(input("ป้อนตัวเลข : "))

for i in range(1, num + 1, 2):
    print(f"{text}{i}{text}{i+1}")
