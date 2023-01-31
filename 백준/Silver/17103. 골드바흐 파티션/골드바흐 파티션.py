import sys
import math
t = int(sys.stdin.readline())
nums = [int(sys.stdin.readline()) for _ in range(t)]
max_num = max(nums)
a = [0] * (max_num + 1)
a[0] = a[1] = 1
# 에라토스테네스의 체
for i in range(2, int(math.sqrt(max_num)) + 1):
    if a[i] == 0:
        j = 2
        while i * j < max_num:
            a[i * j] = 1
            j += 1
for i in nums:
    cnt = 0
    b = []
    for j in range((i//2) + 1):
        if a[j] == 0 and a[i - j] == 0:
            if j not in b or i - j not in b:
                cnt += 1
                b.append(j)
                b.append(i-j)
    print(cnt)