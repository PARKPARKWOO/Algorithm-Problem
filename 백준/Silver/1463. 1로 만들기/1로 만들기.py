INF = int(10e9)
d = [0,0] + ([INF] * 1000000)
x = int(input())
# 보텀 업 방식
for i in range(2, x + 1):
    if i % 3 == 0:
        d[i] = min(d[i // 3] + 1, d[i])
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    d[i] = min(d[i], d[i-1] + 1)


print(d[x])
