import datetime

birth_date = input("Enter your birth date (dd/mm/yyyy) : ")
day, month, year = map(int, birth_date.split("/"))
birth_date = datetime.date(year, month, day)

print("Your birthday is : ", birth_date)

# NOTE: Input
# Enter your birthday (dd/mm/yyyy) : 1/1/1999

# NOTE: Output
# Your birthday is : 1999-01-01
