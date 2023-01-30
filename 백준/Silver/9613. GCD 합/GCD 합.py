from itertools import combinations
# 최소 공약수
def gong(a, b):
    if a >= b:
        if a % b == 0:
            return b
        else:
            return gong(b, a % b)
    elif a <= b:
        if b % a == 0:
            return a
        else:
            return gong(a, b % a)
# 최소 공약수 합 구하기
def gcd(arr):
    x = list(combinations(arr, 2))
    result = 0
    for i, j in x:
        result += gong(i, j)
    return result

t = int(input())
arr = []

for i in range(t):
    s = list(map(int, input().split()))
    arr.append(s[1:])
    print(gcd(arr[i]))
