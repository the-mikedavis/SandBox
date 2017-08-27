def toBaseTen (n, base) :
    ten = 0
    power = len(n)
    for c in n :
        power -= 1
        ten += val(c) * (base ** power)
    return ten

def toNewBase(ten, base) :
    new = ''
    while ten > 0 :
        digit = ten % base
        new = (str(digit) if digit < 10 else chr(digit + 55)) + new
        ten = int(ten/base)
    return new

def val(character) :
    if ord(character) >= 48 and ord(character) <= 57 :
        return ord(character) - 48
    return ord(character.upper()) - 55

print('Welcome to the Base Pyverter! Maximum base supported is base 36')
inno = 0
while True :
    inno = str(input('Enter a number: '))
    base = int(input('Enter an input base: '))
    ten = toBaseTen(inno, base)
    print('In base ten this is: ' + str(ten))
    newbase = int(input('Enter an output base: '))
    print('The new number is: '+toNewBase(ten, newbase))  
    if int(inno, base) < 0 :
        break
