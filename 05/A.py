import math

def main():
    h = 0
    input = fetchInput()

    for i in input:
        r = findRow(i, 127, 0)
        s = findRow(i[7:], 7, 0)
        h = findHighestId(r, s, h)

    print(h)

def fetchInput():
    input = []
    with open('input.txt') as f:
        f = f.read().splitlines()
        for l in f:
            input.append(l)
    return input

def findRow(r, t, b):
    if (r[0] == 'F' or r[0] == 'L'):
        t = math.floor(t - ( t - b ) / 2)
    else:
        b = math.ceil(b + ( t - b ) / 2)
    return b if t==b else findRow(r[1:],t,b)

def findHighestId(r, s, h):
    return h if r*8+s < h else r*8+s

main()
