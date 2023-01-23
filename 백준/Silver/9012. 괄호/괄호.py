t = int(input())
for i in range(t):
    s = input()
    a = list(s)
    sum = 0
    for j in a:
        if j == "(":
            sum += 1
        elif j == ")":
            sum -= 1
        if sum < 0:
            break
    if sum == 0:
        print("YES")
    else:
        print("NO")