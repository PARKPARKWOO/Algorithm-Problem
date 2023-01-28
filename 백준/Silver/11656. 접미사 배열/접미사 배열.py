s = list(input())
srt = []
for i in range(len(s)):
    srt.append(s[i:])
srt.sort()
for i in srt:
    for j in i:
        print(j, end='')
    print()