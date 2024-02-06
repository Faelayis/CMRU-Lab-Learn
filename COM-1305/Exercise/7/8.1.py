def sumA(*n) -> None:
    a = 0
    for x in n:
        a += x
    print(a)


sumA(3, 4, 12, 1)
sumA(10, 20, 30)
