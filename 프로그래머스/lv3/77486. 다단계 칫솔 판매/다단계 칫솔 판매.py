def solution(enroll, referral, seller, amount):
    answer = []
    enroll_referral = {}
    enroll_amount = {}

    for i in range(len(enroll)):
        enroll_referral[enroll[i]] = referral[i]
        enroll_amount[enroll[i]] = 0

    for i in range(len(seller)):
        cur = seller[i]
        profit = amount[i] * 100
        enroll_amount[cur] += amount[i] * 100
        while enroll_referral[cur] != "-":
            if profit == 0:
                break
            profit = profit // 10
            enroll_amount[cur] -= profit
            enroll_amount[enroll_referral[cur]] += profit
            cur = enroll_referral[cur]
        if enroll_referral[cur] == "-":
            profit = profit // 10
            enroll_amount[cur] -= profit
    for member in enroll:
        answer.append(enroll_amount[member])


    return answer