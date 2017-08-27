def collatz(n):
    print(n)
    if n == 1:
        return n
    elif n % 2 == 0:
        return collatz(int(n / 2))
    else:
        return collatz(3 * n + 1)

