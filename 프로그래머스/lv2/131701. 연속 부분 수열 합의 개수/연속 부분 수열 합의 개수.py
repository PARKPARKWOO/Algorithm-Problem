def solution(elements):
    answer = 0
    idx = 1
    for i in range(len(elements)):
        temp = so(idx, elements)
        answer += temp
        print(answer)
        idx += 1
    return answer


def so(n, arr):
    arr_num = []
    for start in range(-1, len(arr) - 1):
        cnt = 0
        j = start
        for j in range(n):
            cnt += arr[j]
            print(cnt)
            j += 1
        if cnt not in arr_num:
            arr_num.append(cnt)
    return len(arr_num)