n = int(input())
d = [1] * 4
d[1] = 3
d[2] = 7
d[3] = 17
for i in range(4, n + 1):
    a = ((d[i-1] * 2) + d[i-2]) % 9901
    d.append(a)
print(d[n] % 9901)
