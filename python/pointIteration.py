import math
def iterate (start):
    n = start
    p = 0
    while n != p:
        p = n
        n = start / ( math.log10(n) / math.log10(2) )
        n = round(n)
        print(n)
