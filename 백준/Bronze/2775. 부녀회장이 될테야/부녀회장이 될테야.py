t = int(input())

for i in range(t):
    k = int(input()) # 층
    n = int(input()) # 호수
    apart = [j for j in range(n + 1)]
    if k == 0:
        print(apart[-1])
    else:
        for q in range(1, k + 1):
            for x in range(1, n + 1):
                apart[x] += apart[x - 1]
        print(apart[-1])
