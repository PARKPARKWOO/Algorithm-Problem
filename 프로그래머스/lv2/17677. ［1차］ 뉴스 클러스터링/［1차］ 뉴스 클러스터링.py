from collections import Counter

def solution(str1, str2):
    answer = 0
    str1 = str1.upper()
    str2 = str2.upper()
    list_1 = []
    list_2 = []
    for i in range(len(str1)-1):
        if str1[i:i+2].isalpha():
            list_1.append(str1[i:i + 2])
    for i in range(len(str2) - 1):
        if str2[i:i+2].isalpha():
            list_2.append(str2[i:i + 2])
    counter1 = Counter(list_1)
    counter2 = Counter(list_2)

    plus = list((counter1 | counter2).elements())
    hash_set = list((counter1 & counter2).elements())
    if len(plus) == 0 and len(hash_set) == 0:
        answer = 1 * 65536
    else:
        temp = (len(hash_set) / len(plus)) * 65536
        answer = int(temp)
    return answer

