from itertools import combinations

n, m = map(int, input().split())
arr = []
for i in range(1, n + 1):
    arr.append(i)
arrr1 = []
for i in sorted(combinations(arr, m)):
    print(*i)