n = int(input())
p = [0] + list(map(int, input().split()))
d = [0] * 1001
for i in range(1, n + 1):
    for j in range(1, i + 1):
        if i % j == 0:
            p[i] = max(p[i], (i // j) * p[j])
        else:
            p[i] = max(p[i], p[j] + p[i % j])
    d[i] = p[i]
print(d[n])

