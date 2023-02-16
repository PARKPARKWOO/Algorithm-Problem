from itertools import product

n, m = map(int, input().split())
arr = []
for i in range(1, n + 1):
    arr.append(i)

for i in sorted(list(product(arr, repeat=m))):
    print(*i)
