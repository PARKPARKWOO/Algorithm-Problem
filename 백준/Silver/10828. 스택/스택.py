import sys

commands = int(sys.stdin.readline())
temp = []
for i in range(commands):
    command = sys.stdin.readline().split()
    if command[0] == "push":
        temp.append(command[1])
    elif command[0] == "top":
        if len(temp) == 0:
            print(-1)
        else:
            print(temp[-1])
    elif command[0] == "pop":
        if len(temp) != 0:
            print(temp[-1])
            temp.pop()
        else:
            print(-1)
    elif command[0] == "size":
        print(len(temp))
    elif command[0] == "empty":
        if len(temp) == 0:
            print(1)
        else:
            print(0)