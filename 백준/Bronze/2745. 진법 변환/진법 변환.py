n, b = input().split()
a = 0
j = len(n) - 1
for i in n:
    if i in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        a += (ord(i)-55) * (int(b) ** j)
    else:
        a += int(i) * (int(b) ** j)
    j -= 1
print(int(a))
