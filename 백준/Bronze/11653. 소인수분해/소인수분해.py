def soinsu(n):
    if n == 1:
        return
    j = 2
    while n != 1:
        if n % j == 0:
            print(j)
            n = n // j
        else:
            j += 1
soinsu(int(input()))