d = [0] * 1001
def fibo(n):
    if n == 1:
        d[n] = 1
        return d[n]
    if n == 2:
        d[n] = 2
        return d[n]
    if d[n] != 0:
        return d[n]
    d[n] = fibo(n-1) + fibo(n-2)
    return d[n]

s = int(input())
print(fibo(s) % 10007)