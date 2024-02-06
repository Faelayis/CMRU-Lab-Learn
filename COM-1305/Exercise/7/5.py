def multiplication_table(n):
    for i in range(1, 13):
        print(n, "x", i, "=", n * i)
    print("\n")


multiplication_table(int(input("Enter a number: ")))
