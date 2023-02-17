from itertools import combinations

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
for i in sorted(combinations(arr, m)):
    print(*i)