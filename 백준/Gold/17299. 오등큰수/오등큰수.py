import sys
from collections import Counter

n = int(input())
a = list(map(int, sys.stdin.readline().split()))
ngf = [-1] * n
count_a = Counter(a)
stack = []
stack.append(0)

for i in range(1, n):
    while stack and count_a[a[stack[-1]]] < count_a[a[i]]:
        ngf[stack.pop()] = a[i]
    stack.append(i)
print(*ngf)