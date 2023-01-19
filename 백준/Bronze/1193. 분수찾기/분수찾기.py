x = int(input())
max_num = 0
line = 0
while x > max_num:
    line += 1
    max_num += line

gap = max_num - x

if line % 2 == 0: # 짝수 줄일때
    a = line - gap # 분자 값
    b = gap + 1 # 분모 값
else: # 홀수일떄
    a = gap + 1 # 분자 값
    b = line - gap
print(f'{a}/{b}')