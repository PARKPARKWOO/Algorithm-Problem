# 최대 공약수 함수
def yack(a, b):
    if a % b == 0:
        return b
    else:
        return yack(b, a % b)
t = int(input())
for i in range(t):
    a, b = map(int, input().split())
    if a >= b:
        print(((a // yack(a, b)) * (b // yack(a, b))) * yack(a, b))
    else:
        print(((a // yack(b, a)) * (b // yack(b, a))) * yack(b, a))