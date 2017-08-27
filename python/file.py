f = open('../remote.txt', 'r')
L = f.readlines()
f.close()
for l in L:
    print(l)
n = open('new.txt', 'a')
for l in L:
    n.write(l)
n.close()
