white = [[0] * 100 for _ in range(100)] # 도화지 값 0 으로 초기화
t = int(input())
result = 0
for i in range(t):
    a, b = map(int, input().split())
    for j in range(a, 10 + a):
        for x in range(b, 10 + b):
            white[j][x] = 1
for i in range(100):
    for j in range(100):
        if white[i][j] == 1:
            result += 1
print(result)