x = ("apple", "banana", "cherry")
y = list(x)
y[1] = "kiwi"  # type: ignore
x = tuple(y)
print(x)

# output: ('apple', 'kiwi', 'cherry')
