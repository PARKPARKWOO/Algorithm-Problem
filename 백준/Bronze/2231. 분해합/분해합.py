n = int(input())
x = 0
for i in range(n):
    s = str(i)
    result = i
    ban = 0 # 반복횟수
    while ban <= len(s) - 1:
        result += int(s[ban])
        ban += 1
    if result == n:
        x = i
        break
print(x)
