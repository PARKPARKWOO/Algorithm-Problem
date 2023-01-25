n = int(input())
s = input()
alpha_num = [0] * n
alpha = []
for i in range(n):
    alpha_num[i] = int(input())

stack = []

for i in range(len(s)):
    if s[i].isalpha():
        stack.append(alpha_num[ord(s[i]) - ord("A")])
    else:
        str1 = stack.pop()
        str2 = stack.pop()
        if s[i] == "+":
            stack.append(str1 + str2)
        elif s[i] == "*":
            stack.append(str1 * str2)
        elif s[i] == "-":
            stack.append(str2 - str1)
        elif s[i] == "/":
            stack.append(str2 / str1)

print('%.2f' %stack[0])
