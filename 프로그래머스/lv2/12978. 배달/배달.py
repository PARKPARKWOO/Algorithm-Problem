def solution(N, road, K):
    INF = int(10e9)
    dis = [[INF] * (N + 1) for _ in range(N + 1)]
    for i in range(N + 1):
        dis[i][i] = 0
    for i in road:
        dis[i[0]][i[1]] = min(dis[i[0]][i[1]], i[2])
        dis[i[1]][i[0]] = min(dis[i[1]][i[0]], i[2])

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            for x in range(1, N + 1):
                dis[j][x] = min(dis[j][x], dis[j][i] + dis[x][i])
    answer = len([i for i in dis[1] if i <= K])
    print('Hello Python')

    return answer


