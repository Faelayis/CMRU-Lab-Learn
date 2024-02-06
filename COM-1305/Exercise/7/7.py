def calculate_triangle_area(base, height):
    area = 0.5 * base * height
    return area


base = float(input("Enter base : "))
height = float(input("Enter height : "))

triangle_area = calculate_triangle_area(base, height)
print("The area is: ", triangle_area)

# NOTE: Input
# Enter base : 10
# Enter height : 10

# NOTE: Output
# The area is : 50.0
