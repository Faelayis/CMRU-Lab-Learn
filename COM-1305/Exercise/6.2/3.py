x = {10, 20, 30, 40, 50}
y = {1, "One", 2, "two"}
l1 = ("a", "e", "i", "o", "u")
z = set(l1)

for i in x:
    print(i, end=" ")
print("\n")

for i in y:
    print(i, end=" ")
print("\n")

for i in z:
    print(i, end=" ")

# NOTE: Output
# 50 20 40 10 30
# two 1 2 One
# o e u a i
