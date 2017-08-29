def inverse (number) :
    n = 1
    p = n
    mul = 1
    while mul < number:
        p = n
        n = n + 1
        mul *= n
    print(p)
