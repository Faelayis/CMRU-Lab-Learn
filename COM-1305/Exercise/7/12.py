options = {"A": "การบวกเลข", "S": "การลบเลข", "M": "การคูณเลข"}


def add(number1, number2):
    return number1 + number2


def sub(number1, number2):
    return number1 - number2


def mul(number1, number2):
    return number1 * number2


def showMenu():
    print("*******************")
    print("     Main Menu     ")
    print("*******************")
    for key, value in options.items():
        print(f" {key} - {value}")
    print("*******************\n")


def createInputChoice():
    choice = input("Enter your choice: ")

    if choice.upper() in options:
        print(f"You selected: {options[choice.upper()]}\n")
        return choice.upper()
    else:
        print("Invalid choice! \n")


def createInputNumber():
    number1 = int(input("Enter First Number: "))
    number2 = int(input("Enter Second Number: "))
    return number1, number2


showMenu()
choice = createInputChoice()


if choice == "A":
    result = add(*createInputNumber())
    print("Result: ", result)
elif choice == "S":
    result = sub(*createInputNumber())
    print("Result: ", result)
elif choice == "M":
    result = mul(*createInputNumber())
    print("Result: ", result)

print("\n")
