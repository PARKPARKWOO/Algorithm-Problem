class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] graph = initGraph(rows, columns);
        return Answer(graph, queries);
    }

    public int[][] initGraph(int rows, int columns) {
        int[][] graph = new int[rows][columns];
        int graph_num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                graph[i][j] = graph_num++;
            }
        }
        return graph;
    }

    public int[] Answer(int[][] graph, int[][] queries) {
        int[] answer = new int[queries.length];
        int minIdx = 0;
        for (int[] query : queries) {
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            int temp = graph[x1][y2];
            int min = temp;
            for (int i = y2 - 1; i >= y1; i--) {
                min = Math.min(min, graph[x1][i]);
                graph[x1][i+1] = graph[x1][i];
            }
            for (int i = x1 + 1; i <= x2; i++) {
                min = Math.min(min, graph[i][y1]);
                graph[i-1][y1] = graph[i][y1];
            }
            for (int i = y1 + 1; i <= y2; i++) {
                min = Math.min(min, graph[x2][i]);
                graph[x2][i-1] = graph[x2][i];
            }
            for (int i = x2 - 1; i >= x1; i--) {
                min = Math.min(min, graph[i][y2]);
                graph[i+1][y2] = graph[i][y2];
            }

            graph[x1+1][y2] = temp;
            answer[minIdx++] = min;
        }
        return answer;
    }
}