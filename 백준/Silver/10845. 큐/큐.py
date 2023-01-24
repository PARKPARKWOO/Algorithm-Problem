from collections import deque
import sys

n = int(input())
commands = ["push", "pop", "size", "empty", "front", "back"]
q = deque()
for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == commands[0]:
        q.append(command[1])
    elif command[0] == commands[1]:
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif command[0] == commands[2]:
        print(len(q))
    elif command[0] == commands[3]:
        if q:
            print(0)
        else:
            print(1)
    elif command[0] == commands[4]:
        if q:
            print(q[0])
        else:
            print(-1)
    elif command[0] == commands[5]:
        if q:
            print(q[len(q) - 1])
        else:
            print(-1)