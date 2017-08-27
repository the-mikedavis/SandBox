def collatz(n):
#    print(n)
    old = n
    a = 0
    while n > 1:
        a += 1
        if n % 2 == 0:
            n = int(n / 2)
        else:
            n = int(3 * n + 1)
#        print(n)
    print('%d -> %d in %d steps' % (old, n, a))
