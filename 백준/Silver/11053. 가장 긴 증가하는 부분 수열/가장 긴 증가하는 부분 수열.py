n = int(input())
d = [1 for _ in range(n + 1)]
a = list(map(int, input().split()))
for i in range(1, n):
    for j in range(0, i):
        if a[i] > a[j]:
            d[i] = max(d[i], d[j] + 1)

print(max(d))
