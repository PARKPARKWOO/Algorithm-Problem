n, b = map(int, input().split())
def chg(n, b):
    s = ""
    while n >= 1:
        if n % b >= 10:
            s = chr((n % b) + 55) + s
            n = n // b
        else:
            s = str(n % b) + s
            n = n // b
    return s
print(chg(n, b))
