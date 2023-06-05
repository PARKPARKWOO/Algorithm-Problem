def solution(elements):
    result = set()
    elements_len = len(elements)
    elements = elements * 2
    for i in range(elements_len):
        for j in range(elements_len):
            result.add(sum(elements[j:j+i + 1]))
    return len(result)