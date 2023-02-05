n = int(input())
a = list(map(int, input().split()))
d = [0] * n
res = 0
for i in range(n):
    res += a[i]
    d[i] = res
    if res <= 0:
        res = 0
print(max(d))
