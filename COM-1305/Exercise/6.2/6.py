s1 = {1, 3, 5, 7, 9}

s1.add(10)
print(s1)

s1.remove(3)
print(s1)

s1.difference_update({1, 5})
print(s1)

s1.clear()
print(s1)

# NOTE: Output
# {1, 3, 5, 7, 9, 10}
# {1, 5, 7, 9, 10}
# {7, 9, 10}
# set()
