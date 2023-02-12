import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
error = list(map(int, sys.stdin.readline().split()))

min_cnt = abs(100 - n) #  - 1 혹은 + 1 로 찾기

for nums in range(1000001):
    num = str(nums)
    for j in range(len(num)):
        if int(num[j]) in error:
            break
        elif j == len(num) - 1:
            min_cnt = min(min_cnt, abs(int(num) - n) + len(num))

print(min_cnt)
