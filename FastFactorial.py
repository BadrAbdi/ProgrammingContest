n = int(input())
ch = 0
for x in range(0,n):
    f = int(input())
    if(f<=33):
        d = 1
        for y in range(1,f+1):
            d *=y
            d %= 4294967296
        print(d)
    else:
        print(0)