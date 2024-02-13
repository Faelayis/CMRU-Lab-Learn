import random

r = random.randint(0, 10)
print(r)
print(random.random())
a = ["Anna", "Betty", "Cathy", "Dorothy", "Eddy", "Freddy", "Iggy", "Hiccup"]
print(random.choice(a))
print(random.choices(a))

# NOTE: Output
# 0.9217484726341889
# Hiccup
# ['Betty']
