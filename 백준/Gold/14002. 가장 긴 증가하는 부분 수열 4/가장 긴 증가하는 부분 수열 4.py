n = int(input())
a = list(map(int, input().split()))
d = [1 for _ in range(n + 1)]

for i in range(1, n):
    for j in range(0, i):
        if a[i] > a[j]:
            d[i] = max(d[i], d[j] + 1)
print(max(d))
b = []

max_num = max(d)
for i in range(n-1, -1, -1):
    if d[i] == max_num:
        b.append(a[i])
        max_num -= 1
b.sort()
print(*b)