t = int(input())
for i in range(t):
    s = list(map(str, input().split()))
    for j in s:
        print(j[::-1], end=' ')
