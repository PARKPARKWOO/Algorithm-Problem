n, m = map(int, input().split())
arr = list(map(int, input().split()))
result = 0
# 첫번째 카드
for i in range(n):
    # 두번째 카드
    for j in range(i + 1, n):
        # 세번째 카드
        for k in range(j + 1, n):
            if arr[i] + arr[j] + arr[k] > m:
                continue
            else:
                result = max(result, arr[i] + arr[j] + arr[k])
print(result)