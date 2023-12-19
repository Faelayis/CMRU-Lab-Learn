def multiplication_table(x):
    for number in range(1, 13):
        print(f"{x} x {number} = {x * number}")


try:
    multiplication_table(int(input("Enter Number :")))
except ValueError:
    print("Please enter a number only.")
