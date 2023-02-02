n = int(input())
p = [0] + list(map(int, input().split()))
d = [10001] * 1001

for i in range(1, n + 1):
    for j in range(1, i + 1):
        p[i] = min(p[i], p[i-j] + p[j], d[i])
        d[i] = p[i]
print(d[n])