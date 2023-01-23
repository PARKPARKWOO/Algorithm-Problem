import sys
input = sys.stdin.readline
n = int(input())
a = [] # 스택 리스트
for i in range(n):
    command = list(map(str, input().split()))

    if command[0] == "push":
        a.append(command[1])
    elif command[0] == 'pop':
        if len(a) > 0:
            v = a.pop()
            print(v)
        elif len(a) == 0:
            print(-1)
    elif command[0] == 'size':
        print(len(a))
    elif command[0] == 'empty':
        if len(a) == 0:
            print(1)
        elif len(a) > 0:
            print(0)
    elif command[0] == 'top':
        if len(a) > 0:
            print(a[len(a) - 1])
        elif len(a) == 0:
            print(-1)