def solution(skill, skill_trees):
    answer = 0
    for i in range(len(skill_trees)):
        error = 0
        num = 0
        for j in skill_trees[i]:
            if j in skill:
                if j == skill[num]:
                    num += 1
                else:
                    error += 1
                    break
        if error == 0:
            answer += 1
    return answer