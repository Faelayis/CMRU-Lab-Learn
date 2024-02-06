def SumNumber(number):
    sum = 0
    for i in range(1, number + 1):
        sum = sum + i
    print("ผลรวมของตัวเลข 1 ถึง %d เท่ากับ %d " % (number, sum))


SumNumber(5)

# NOTE: Output
# ผลรวมของตัวเลข 1 ถึง 5 เท่ากับ 15
