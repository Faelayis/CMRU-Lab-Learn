dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}
print(dict1.get(3))
dict1.pop(3)
print(dict1)
dict1.popitem()
dict1.update({1: "หนึ่ง"})
print(dict1)
dict1.clear()
print(dict1)

# NOTE: Output
# Three
# {1: 'One', 2: 'Two', 4: 'Four', 5: 'Five'}
# {1: 'หนึ่ง', 2: 'Two', 4: 'Four'}
# {}
