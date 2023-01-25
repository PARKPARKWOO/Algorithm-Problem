while True:
    a, b = map(int, input().split())
    if 0 >= a or 0 >= b or 10 <= a or 10 <= b:
        break
    print(a + b)