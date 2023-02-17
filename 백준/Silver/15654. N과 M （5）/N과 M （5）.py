from itertools import permutations

n, m = map(int, input().split())
arr = list(map(int, input().split()))
for i in sorted(permutations(arr, m)):
    print(*i)