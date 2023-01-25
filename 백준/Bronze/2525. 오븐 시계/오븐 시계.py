h, m = map(int, input().split())
c = int(input())

minute = m + c # 디지털 시계의 분
hour = h # 디지털 시계의 시
while minute >= 60: # minute 의 값이 60이상일때 반복
    if minute >= 60: # 60분 이상일때
        minute -= 60 # 60분을 빼고
        hour += 1 # 1시간 추가
        if hour > 23: # 23시 이상이라면 ( 00시)
            hour = 0 # 00시

print(hour, minute, end=' ')