def solution(k, tangerine):
    answer = 0
    max_idx = max(tangerine)
    cnt_arr = [0] * (max_idx+1)

    for i in range(len(tangerine)):
        cnt_arr[tangerine[i]] += 1

    cnt_arr.sort(reverse=True)
    for i in cnt_arr:
        if k > 0:
            k -= i
            answer += 1
    print(answer)
    return answer
