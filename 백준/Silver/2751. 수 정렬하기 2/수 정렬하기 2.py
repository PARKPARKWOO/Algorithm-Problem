import sys
input = sys.stdin.readline
n = int(input())
a = []
for i in range(n):
    aw = int(input())
    a.append(aw)
a.sort()
for i in a:
    print(i)