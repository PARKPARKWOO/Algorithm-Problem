alpha_s = "abcdefghijklmnopqrstuvwxyz"
alpha_b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
num = "0123456789"
while True:
    try:
        s = input()
        blank = 0
        alpha_snum = 0
        alpha_bnum = 0
        snum = 0
        for j in s:
            if j in alpha_s:
                alpha_snum += 1
            elif j in alpha_b:
                alpha_bnum += 1
            elif j in num:
                snum += 1
            else:
                blank += 1
        print(alpha_snum, alpha_bnum, snum, blank, end=' ')
    except EOFError:
        break