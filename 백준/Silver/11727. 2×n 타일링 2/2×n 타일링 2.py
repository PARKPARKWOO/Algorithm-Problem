d = [0] * 1001
def tile(n):
    if n == 1:
        d[1] = 1
        return d[1]
    if n == 2:
        d[2] = 3
        return d[2]
    if d[n] != 0:
        return d[n]
    d[n] = tile(n-1) + (tile(n-2) * 2)
    return d[n]
n = int(input())
print(tile(n) % 10007)