n = int(input())
a = list(map(int, input().split()))
stack = [] # 인덱스로 사용
answer = [-1] * n
stack.append(0) # 처음 인덱스 0

for i in range(1, n):
    while stack and a[stack[-1]] < a[i]:
        answer[stack.pop()] = a[i]
    stack.append(i)
print(*answer)