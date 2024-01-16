numbers: list[int] = [99, 10, 20, 50, 15]

length = len(numbers)
print(length)

maximum = max(numbers)
print(maximum)

minimum = min(numbers)
print(minimum)

total = sum(numbers)
print(total)

del numbers[0]
print(numbers)

# outout:
# len : 5
# max : 99
# min : 10
# sum : 194
# del 0 : [10, 20, 50, 15]
