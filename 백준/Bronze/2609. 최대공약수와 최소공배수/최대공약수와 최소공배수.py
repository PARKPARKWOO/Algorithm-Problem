# 최대 공약수 함수
def yack(a, b):
    if a % b == 0:
        return b
    else:
        return yack(b, a % b)
a, b = map(int, input().split())
if a >= b:
    print(yack(a, b))
    print(((a // yack(a, b)) * (b // yack(a, b))) * yack(a, b))
else:
    print((yack(b, a)))
    print(((a // yack(b, a)) * (b // yack(b, a))) * yack(b, a))