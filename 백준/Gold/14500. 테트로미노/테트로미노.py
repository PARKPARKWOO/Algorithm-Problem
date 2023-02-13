import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

move = [(0, 1), (0, -1), (1, 0), (-1, 0)]
visited = [[False] * m for _ in range(n)]
max_Value = 0
def dfs(x, y, result, depth):
    global max_Value
    if depth == 4:
        max_Value = max((max_Value, result))
        return

    for i in range(4):
        dx = x + move[i][0]
        dy = y + move[i][1]
        if 0 <= dx < n and 0 <= dy < m and not visited[dx][dy]:
            visited[dx][dy] = True
            dfs(dx, dy, result + graph[dx][dy], depth + 1)
            visited[dx][dy] = False

def exce(x, y):
    global max_Value
    for i in range(4):
        tmp = graph[x][y]
        for j in range(3):
            t = (i+j) % 4
            dx = x + move[t][0]
            dy = y + move[t][1]
            if not(0 <= dx < n and 0 <= dy < m ):
                tmp = 0
                break
            tmp += graph[dx][dy]
        max_Value = max(max_Value, tmp)

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, graph[i][j], 1)
        visited[i][j] = False

        exce(i, j)
print(max_Value)
