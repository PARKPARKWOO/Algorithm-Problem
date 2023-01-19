import sys
input = sys.stdin.readline
def merge_sort(a):
    if len(a) == 1:
        return a
    mid = (len(a) + 1) // 2 # 병합정렬을 위한 중간 값
    x = []
    left = merge_sort(a[:mid]) # 왼쪽값을 재귀함수로 정렬
    right = merge_sort(a[mid:]) # 오른쪽 값을 재귀 함수로 정렬
    l = 0
    r = 0
    while l < len(left) and r < len(right):
        if left[l] < right[r]:
            arr.append(left[l])
            x.append(left[l])
            l += 1
        else:
            arr.append(right[r])
            x.append(right[r])
            r += 1
    while l < len(left):
        arr.append(left[l])
        x.append(left[l])
        l += 1
    while r < len(right):
        arr.append(right[r])
        x.append(right[r])
        r += 1
    return x

n, k = map(int, input().split())
a = list(map(int, input().split()))
arr = []
merge_sort(a)
if len(arr) >= k:
    print(arr[k-1])
else:
    print(-1)