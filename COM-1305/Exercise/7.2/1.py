from datetime import date


def display_birthdate(day, month, year):
    birthdate = date(year, month, day)
    formatted_date = birthdate.strftime("%d/%m/%Y")
    print("Your birthday is :", formatted_date)


display_birthdate(1, 1, 1999)

# NOTE: Output
# Your birthday is : 1/1/1999
