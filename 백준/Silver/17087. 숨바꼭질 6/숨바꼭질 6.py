import math
n, s = map(int, input().split())
bro = list(map(int, input().split())) # 동생 위치
a = []
for i in bro:
    if s > i:
        a.append(s - i)
    else:
        a.append(i - s)
print(math.gcd(*a))