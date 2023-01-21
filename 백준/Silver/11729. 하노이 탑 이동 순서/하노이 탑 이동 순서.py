def hanoi_tower(n, start, end, target):
    if n == 1:
        print(start, end)
        return

    hanoi_tower(n - 1, start, target, end)  # 2번째 고리에 n-1빼고 옮기기
    print(start, end)  # 수행과정 출력
    hanoi_tower(n - 1, target, end, start)  # 목표 고리에 전부 옮기기


n = int(input())
print(2 ** n - 1) # 하노이 알고리즘은 2^n-1
hanoi_tower(n, 1, 3, 2)