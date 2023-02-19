from itertools import combinations_with_replacement
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
for i in sorted(combinations_with_replacement(arr, m)):
    print(*i)