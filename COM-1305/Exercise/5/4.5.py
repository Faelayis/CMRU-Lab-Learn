sum = 0
count = 1

while count <= 5:
    try:
        num = int(input(f"Enter Number {count}: "))
        sum += num
        count += 1
    except ValueError:
        print("Please enter a number.")
    finally:
        avg = sum / 5
        print(f"Sum = {sum}, Avg = {avg}")
