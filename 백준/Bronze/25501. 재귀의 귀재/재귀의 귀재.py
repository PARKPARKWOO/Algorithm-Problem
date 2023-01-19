def isPalindrome(s):
    a = -1 # 시작 인덱스
    b = len(s) # 끝 인덱스
    c = 0 # 출력 값
    cnt = 0 # 몇번 반복
    # recursion 함수 구하기 = 반복 횟수 구하기
    while a <= b:
        cnt += 1
        a += 1
        b -= 1
        # 글자가 다르면 팰린드롬이 아님 
        if s[a] != s[b]:
            return print(0, cnt, end=' ')
        # a가 b를 넘을때까지 반복한다면 팰린드롬 
        if a >= b:
            return print(1, cnt, end=' ')



t = int(input())
for i in range(t):
    s = input()
    isPalindrome(s)