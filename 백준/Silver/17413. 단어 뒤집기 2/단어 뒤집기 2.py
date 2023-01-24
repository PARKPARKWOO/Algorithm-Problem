s = list(input())
i = 0
start = 0
while len(s) > i:
    if s[i] == "<":
        i += 1
        while s[i] != ">":
            i += 1
        i += 1
    elif s[i].isalnum():
        start = i
        while i < len(s) and s[i].isalnum():
            i += 1
        word = s[start:i]
        word.reverse()
        s[start:i] = word
    else:
        i += 1
print("".join(s))
