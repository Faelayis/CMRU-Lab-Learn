import datetime

numbers = [int(num) for num in input("Enter Time (0 0 0) : ").split()[:3]]

if len(numbers) < 3:
    numbers += [0] * (3 - len(numbers))


def create_time(hours, minutes, seconds):
    time = datetime.time(hours, minutes, seconds)
    return time


print(f"Create Custom Time : {create_time(*numbers)}")

# NOTE: Input
# Enter Time (0 0 0) : 9 52 0

# NOTE: Output
# Create Custom Time : 09:52:00
