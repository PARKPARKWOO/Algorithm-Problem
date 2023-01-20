import sys
sys.setrecursionlimit(10 ** 8)
input = sys.stdin.readline
n = int(input())
# 2차원 리스트 공백으로 초기화
a = [[' '] * n for _ in range(n)]

def star(n):
    k = n // 3
    # 제일 작은 값인 n 이 3일때  값 지정
    if n == 3:
        a[1] = ['*', ' ', '*']
        a[0][:3] = a[2][:3] = ['*', '*', '*']
        return
    # 3씩 나눈 값으로 재귀하여 실행
    star(k)
    # 2차원 그래프를 k 씩 건너 띄면서 확인
    for i in range(0, n, k):
        for j in range(0, n, k):
            # (n/3)(n/3) 의 정사각형을 제외한 나머지 채워넣기 재귀하며 채워넣음 
            if i != k or j != k:
                for q in range(k):
                    a[i + q][j: j + q] = a[q][:k]

star(n)
for i in range(n):
    for j in range(n):
        print(a[i][j], end='')
    print()
