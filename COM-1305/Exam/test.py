text = input("ป้อนสัญลักษณ์พิเศษ : ")
num = int(input("ป้อนตัวเลข : "))

loop = 1
count = 0

for i in range(1, num + 1):
    count += 1
    for j in range(1, num + 1):
        if loop % 2 == 0:
            print(count, end=" ")
        else:
            print(text, end=" ")
        loop += 1
