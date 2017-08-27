class Collat:

    def __init__(self, n=1):
        self.no = n
        self.r = int(2 * n)
        self.l = int((n - 1) / 3)

    def right(self):
        return Collat(self.r)

    def left(self):
        if (self.no - 1) % 3 == 0 and self.l != 0:
            return Collat(self.l)
        else:
            return None

    def __str__(self):
        return str(self.no)

    def __gt__(self, other):
        return self.no > other.no

    def __eq__(self, other):
        return self.no == other.no

    def __hash__(self):
        return self.no
#        st = str(self.no)
#        sm = 0
#        for c in st:
#            sm = 31 * sm + int(c)



root = Collat()
L = []
L.append(root)
n = 0
while n < 50:
    L.append(root.right())
    if root.left() is not None:
        L.append(root.left())
    root = L[n]
    n += 1

for l in sorted(set(L)):
    print(l)
