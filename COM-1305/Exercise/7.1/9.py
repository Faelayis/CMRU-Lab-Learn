def sumA(*n):
    a = 0
    for x in n:
        a += x
    return a


numbers = [int(num) for num in input("Enter numbers: ").split()]
result = sumA(*numbers)

print("Sum:", result)
print("Average:", result / len(numbers))
print()
