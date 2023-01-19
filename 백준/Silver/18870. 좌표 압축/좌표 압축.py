n = int(input())
x = list(map(int, input().split()))
set_x = set(x)
list_x = list(set_x)
list_x.sort()
a = {}
for i in range(len(list_x)):
    a[list_x[i]] = i

for j in x:
    print(a[j], end=' ')