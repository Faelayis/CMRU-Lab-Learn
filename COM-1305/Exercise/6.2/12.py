dict1 = {1: "One", 2: "Two", 3: "Three", 4: "Four", 5: "Five"}
dict2 = dict1.copy()
print(dict2)
dict3 = dict(dict1)
print(dict3)

# NOTE: Output
# dict2 : {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 5: 'Five'}
# dict3 : {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four', 5: 'Five'}
