n = int(input())
cnt = 0
a = list(map(int, input().split()))
for i in a:
    error = 0
    if i <= 1:
        error += 1
    for j in range(2, i):
        if i % j == 0:
            error += 1
    if error == 0:
        cnt += 1
print(cnt)
