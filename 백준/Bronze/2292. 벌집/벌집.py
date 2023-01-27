n = int(input())
bang = 1
a = 1
while n > a:
    a += 6 * bang
    bang += 1
print(bang)