from collections import deque
import sys
n = int(input())
q = deque()
commands = ["push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back"]
for i in range(n):
    command = sys.stdin.readline().split()

    if command[0] == commands[0]:
        q.appendleft(command[1])
    elif command[0] == commands[1]:
        q.append(command[1])
    elif command[0] == commands[2]:
        if q:
            print(q.popleft())
        else:
            print(-1)
    elif command[0] == commands[3]:
        if q:
            print(q.pop())
        else:
            print(-1)
    elif command[0] == commands[4]:
        print(len(q))
    elif command[0] == commands[5]:
        if q:
            print(0)
        else:
            print(1)
    elif command[0] == commands[6]:
        if q:
            print(q[0])
        else:
            print(-1)
    elif command[0] == commands[7]:
        if q:
            print(q[-1])
        else:
            print(-1)