def solution(citations):
    citations.sort(reverse=True)
    for idx, citation in enumerate(citations):
        print(idx, citation)
        if idx >= citation:
            return idx
    return len(citations)
