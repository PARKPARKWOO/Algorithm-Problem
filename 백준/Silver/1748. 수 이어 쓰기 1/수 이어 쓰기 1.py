n = input()
len_n = len(n) - 1
line = 0
num = 0
while line < len_n:
    num += 9 * (10 ** line) * (line + 1)
    line += 1
num += (int(n) - (10 ** line) + 1) * (line + 1)
print(num)