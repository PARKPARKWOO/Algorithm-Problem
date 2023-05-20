from math import gcd
def solution(arr):
    answer = arr[0]
    for i in arr:
        answer = i * answer // gcd(i ,answer)
    print(answer)
    return answer