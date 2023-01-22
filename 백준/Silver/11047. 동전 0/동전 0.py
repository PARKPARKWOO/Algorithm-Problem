import sys
input = sys.stdin.readline
n, k = map(int, input().split())
cnt = 0
u = 0
a = []
for i in range(n):
    aw = int(input())
    a.append(aw)
a.sort(reverse=True)

while u < n:
    if k >= a[u]:
        cnt += 1
        k -= a[u]
    elif k < 1:
        break
    else:
        u += 1
print(cnt)