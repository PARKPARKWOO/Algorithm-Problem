
def solution(n):
    if n <= 3:
        return n
    d = [0] * (n + 1)
    d[1] = 1
    d[2] = 2
    d[3] = 3
    for i in range(4, n + 1):
        d[i] = (d[i-1] + d[i-2]) % 1234567
    return d[n] % 1234567