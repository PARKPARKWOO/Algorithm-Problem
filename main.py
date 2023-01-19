# 팩토리얼 재귀 함수
def factorial(n):
    # n의 값이 1이하일경우 1 리턴
    if n <= 1:
        return 1
    # 아니면 n 을 곱한 factorial(n-1) 값 재귀
    elif n > 1:
        return n * factorial(n-1)
n = int(input())
print(factorial(n))