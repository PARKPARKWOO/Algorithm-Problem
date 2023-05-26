def bracket(s):
    stack = []
    for i in s:
        if len(stack) == 0: stack.append(i)
        elif stack[-1] == "(" and i == ")": stack.pop()
        elif stack[-1] == "[" and i == "]": stack.pop()
        elif stack[-1] == "{" and i == "}": stack.pop()
        else:
            stack.append(i)
    if len(stack) == 0:
        return 1
    return 0



def solution(s):
    answer = 0

    for i in range(len(s)):
        if bracket(s):  answer += 1
        s = s[1:] + s[:1]
    print(answer)
    return answer