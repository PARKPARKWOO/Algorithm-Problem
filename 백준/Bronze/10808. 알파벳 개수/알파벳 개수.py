alpha = "abcdefghijklmnopqrstuvwxyz"
a = [0] * len(alpha)
s = input()
for i in s:
    for j in range(len(alpha)):
        if i == alpha[j]:
            a[j] += 1
print(*a)