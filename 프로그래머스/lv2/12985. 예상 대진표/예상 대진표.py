import math
def solution(n,a,b):
    answer = 0

    while True:
        answer += 1
        temp_a = math.ceil(a / 2)
        temp_b = math.ceil(b / 2)
        if temp_a == temp_b:
            break
        else:
            a = math.ceil(a / 2)
            b = math.ceil(b / 2)

    print(answer)
    return answer
