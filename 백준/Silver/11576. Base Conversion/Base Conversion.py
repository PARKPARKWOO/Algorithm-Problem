a, b = map(int, input().split())
m = int(input())
a_num = list(map(int, input().split()))
b_num = 0
result = []
j = m - 1
for i in range(m):
    b_num += a_num[i] * (a ** j)
    j -= 1
while b_num:
    nam = b_num % b
    result.append(str(nam))
    b_num = b_num // b
result = result[::-1]
fin = " ".join(result)
print(fin)
