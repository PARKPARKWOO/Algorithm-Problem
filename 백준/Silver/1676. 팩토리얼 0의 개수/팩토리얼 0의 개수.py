cnt = 0
def fac(n):
    if n <= 1:
        return 1
    else:
        return n * fac(n - 1)
n = int(input())
for i in str(fac(n))[::-1]:
    if i != "0":
        break
    cnt += 1
print(cnt)