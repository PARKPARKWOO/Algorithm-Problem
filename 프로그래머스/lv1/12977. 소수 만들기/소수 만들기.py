import math
from itertools import combinations
def solution(nums):
    answer = 0
    arr = [0] * 3001
    arr[0] = arr[1] = 1
    for i in range(2, int(math.sqrt(3000)) + 1):
        if arr[i] == 0:
            j = 2
            while i * j < 3000:
                arr[i * j] = 1
                j += 1
    for i in combinations(nums, 3):
         if arr[sum(i)] == 0:
             answer += 1
             print(f'{i}을 이용해서 {sum(i)}을 만들 수 있습니다.'.replace("(", "[").replace(")", "]"))

    return answer

    return answer