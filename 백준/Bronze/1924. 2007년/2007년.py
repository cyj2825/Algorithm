x, y = map(int, input().split())

if x == 2:
    y += 31
elif x == 3:
    y += (31+28)
elif x == 4:
    y += (31*2+28)
elif x == 5:
    y += (31*2+28+30)
elif x == 6:
    y += (31*3+28+30)
elif x == 7:
    y += (31*3+28+30*2)
elif x == 8:
    y += (31*4+28+30*2)
elif x == 9:
    y += (31*5+28+30*2)
elif x == 10:
    y += (31*5+28+30*3)
elif x == 11:
    y += (31*6+28+30*3)
elif x == 12:
    y += (31*6+28+30*4)
else:
    y = y

if y%7 == 0:
    print("SUN")
elif y%7 == 1:
    print("MON")
elif y%7 == 2:
    print("TUE")
elif y%7 == 3:
    print("WED")
elif y%7 == 4:
    print("THU")
elif y%7 == 5:
    print("FRI")
else:
    print("SAT")