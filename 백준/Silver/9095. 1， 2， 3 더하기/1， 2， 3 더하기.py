t = int(input())
d = [0] * 12
def plus(n):
    if n == 1:
        d[1] = 1
        return d[1]
    elif n == 2:
        d[2] = 2
        return d[2]
    elif n == 3:
        d[3] = 4
        return d[3]
    if d[n] != 0:
        return d[n]
    d[n] = plus(n-1) + plus(n-2) + plus(n-3)
    return d[n]
for i in range(t):
    n = int(input())
    print(plus(n))
