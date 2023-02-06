n, k = map(int, input().split())

d = [[0 for _ in range(201)] for _ in range(201)]

for i in range(n + 1):
    d[1][i] = 1
    d[2][i] = i + 1

for i in range(1, k + 1):
    d[i][1] = i
    for j in range(2, n + 1):
        d[i][j] = (d[i-1][j] + d[i][j-1]) % 1000000000
print(d[k][n] % 1000000000)

