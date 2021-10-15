import math

def main():
    input = fetchInput()
    ids = []
    id = 0

    for i in input:
        r = findRow(i, 127, 0)
        s = findRow(i[7:], 7, 0)
        ids.append(r*8+s)

    ids = sorted(ids)

    for i in range(len(ids)-1):
        if ids[i]+1 != ids[i+1]:
            id = ids[i]+1

    print(id)

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

main()
