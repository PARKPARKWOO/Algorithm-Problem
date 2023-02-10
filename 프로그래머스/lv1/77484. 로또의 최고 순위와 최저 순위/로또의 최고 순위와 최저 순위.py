def solution(lottos, win_nums):
    answer = []
    high, low = 0, 0
    num = 6
    for i in lottos:
        for j in win_nums:
            if i == 0:
                high += 1
                break
            if i == j:
                if high >= 6:
                    low += 1
                else:
                    high += 1
                    low += 1
    if low > 0:
        low -= 1
    if high > 0:
        high -= 1
    answer.append(num - high)
    answer.append(num - low)

    return answer