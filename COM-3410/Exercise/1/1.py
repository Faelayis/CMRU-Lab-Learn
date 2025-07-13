num_books = int(input("How many books: "))
total_price = float(input("How much: "))

if num_books >= 2 and total_price > 300:
    discount = total_price * 0.10
    total_price -= discount

print(f"You have to pay {int(total_price)} bath.")