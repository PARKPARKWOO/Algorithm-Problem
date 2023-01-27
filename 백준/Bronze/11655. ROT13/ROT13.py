s = input()
a = ""
for j in s:
    if 97 <= ord(j) < 110 or 65 <= ord(j) < 78:
        p = ord(j) + 13
        a += chr(p)
    elif 110 <= ord(j) <= 122 or 78 <= ord(j) <= 90:
        p = ord(j) - 13
        a += chr(p)
    else:
        a += j

print(a)
