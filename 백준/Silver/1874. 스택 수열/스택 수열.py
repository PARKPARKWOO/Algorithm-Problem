import sys
input = sys.stdin.readline
n = int(input())
s = [] # 스택 넣을 리스트
b = [] # 부호 넣을 리스트
a = 1
c = 0
for i in range(n):
    num = int(input())
    while a <= num:
        s.append(a)
        b.append("+")
        a += 1
    if s[-1] == num:
        s.pop()
        b.append("-")
    else:
        c = 1


if c == 0:
    for i in b:
        print(i)
else:
    print("NO")