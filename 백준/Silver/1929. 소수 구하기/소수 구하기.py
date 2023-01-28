import math
m, n = map(int, input().split())
arr = [0] * (n + 1)
for i in range(2, int(math.sqrt(n)) + 1):
    if arr[i] == 0:
        j = 2
        while i * j < n + 1:
            arr[i * j] = 1
            j += 1
for i in range(m, n + 1):
    if i <= 1:
        continue
    if arr[i] == 0:
        print(i)