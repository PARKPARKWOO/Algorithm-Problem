def solution(cacheSize, cities):
    answer = 0
    stack = []
    if cacheSize == 0:
        answer += len(cities) * 5
        return answer
    for i in cities:
        i = i.upper()
        if i in stack:
            answer += 1
            stack.pop(stack.index(i))
        else:
            answer += 5
            if len(stack) >= cacheSize:
                stack.pop(0)
        stack.append(i)

    return answer