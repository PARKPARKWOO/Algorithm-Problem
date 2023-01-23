t = int(input())
for i in range(t):
    s = list(input().split())
    for j in s:
        print(j[::-1], end=' ')
