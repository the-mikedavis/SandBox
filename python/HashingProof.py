from string import ascii_lowercase

def makelist () :
    L = []
    for i in ascii_lowercase :
        for j in ascii_lowercase :
            L.append(str(i) + str(j))
    return L

def test () :
    S = makelist()
    for s in S :
        for r in S :
            if r != s :
                if hash(r) == hash(s) :
                    return False
    return True

print(test())
