s = input()
iron = 0 # 레이저 자를때 쇠막대기 수
result = 0 # 쇠 막대기 총 수
iron_num = 0 # 쇠 막대기 총 수
for i in range(len(s)):
    if s[i] == "(" and s[i + 1] == ")":
        result += iron
    elif s[i] == "(" and s[i + 1] != ")":
        iron += 1
        iron_num += 1
    elif s[i] == ")" and s[i - 1] != "(":
        iron -= 1
print(result + iron_num)