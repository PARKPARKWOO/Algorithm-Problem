m = 0
dice = [0] * 7 # 주사위 리스트 초기화
# 주사위 정보 입력받고 dice 리스트에 넣기
for i in list(map(int, input().split())):
    dice[i] += 1
    m = max(m, i) # 가장 큰 눈
cnt = max(dice) # 같은 눈의 개수
same = dice.index(cnt) # 같은 눈의 주사위 숫자

if cnt == 3:
    print(10000 + (1000 * same))
elif cnt == 2:
    print(1000 + (100 * same))
else:
    print(100 * m)