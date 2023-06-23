from collections import Counter
def solution(want, number, discount):
    answer = 0

    for i in range(len(discount)):
        cnt = Counter(discount[i:i+10])
        temp = 0
        for j in range(len(want)):
            if cnt[want[j]] == number[j]:
                temp += 1

        if temp == len(want):
            answer += 1

    return answer