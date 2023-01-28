import math
arr = [0] * 1000001
arr[0] = arr[1] = 1
for i in range(2, int(math.sqrt(1000000))+ 1):
    if arr[i] == 0:
        j = 2
        while i * j < 1000001:
            arr[i * j] = 1
            j += 1
while True:
    n = int(input())
    half = n // 2
    a = 0
    b = n
    if n == 0:
        break
    while b >= half and a <= half:
        if b + a == n and arr[b] == 0 and arr[a] == 0:
            print(f'{n} = {a} + {b}')
            break
        else:
            b -= 1
            a += 1
        if b <= half and a >= half and b + a != n and arr[b] != 0 and arr[a] != 0:
            print("Goldbach's conjecture is wrong.")
            break

