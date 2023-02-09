import itertools

a = []
for i in range(9):
    s = int(input())
    a.append(s)

a.sort()
for i in itertools.combinations(a, 7):
    if sum(i) == 100:
        for j in sorted(i):
            print(j)
        break